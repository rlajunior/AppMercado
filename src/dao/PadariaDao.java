package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Eletronico;
import negocio.Padaria;


public class PadariaDao {
	
//	
//	public boolean remove (int id) {
//		
//		String sql = "DELETE FROM padaria WHERE idproduto = " + id;
//			
//		try {
//			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
//			ps.executeUpdate(sql);
//			return true;		
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
	
	
	 public static Object obterlista() {
		 
		 List<Produto> lista = new ArrayList<Produto>();
		 
		 String sql = "SELECT * FROM padaria pa inner join produto p on pa.idproduto=p.id ORDER BY p.id";
		 
				 try {
						PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()){
							lista.add(
									new Padaria(
											rs.getInt("id"), 
											rs.getString("nome"),
											rs.getFloat("peso"),
											rs.getDouble("valor"),
											rs.getString("localdepartamento"),
											rs.getString("Localretirada"),
											rs.getString("nomeatendente")
											)
								);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return lista;
				}
	 
	 			

	 public static boolean salvar(Padaria padaria) {
			try {

				
				ProdutoDao pdao = new ProdutoDao();
				
				Produto produtoSalvo = pdao.salvar(padaria);
				
				
				PreparedStatement ps = 
						Conexao.obterConexao().prepareStatement(
								"INSERT INTO padaria "
										+ "(localdepartamento, localretirada, nomeatendente, idproduto) "
										+ "VALUES "
										+ "(?,?,?,?)"
									);

						ps.setString(1, padaria.getLocalDepartamento());
						ps.setString(2, padaria.getLocaRetirada());
						ps.setString(3, padaria.getNomeAtendente());
						ps.setInt(4, produtoSalvo.getId());
						ps.execute();
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return false;
			
		}


}
