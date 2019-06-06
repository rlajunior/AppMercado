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
	
	
	 public static Object obterlista() {
		 
		 List<Produto> lista = new ArrayList<Produto>();
		 
		 String sql = "SELECT * FROM padaria pa inner join produto p on pa.idpadaria=p.idproduto ORDER BY p.idpadaria";
		 
				 try {
						PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()){
							lista.add(
									new Padaria(
											rs.getInt("idproduto"), 
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
										+ "(localdepartamento, localretirada, nomeatendente) "
										+ "VALUES "
										+ "(?,?,?)"
									);

						ps.setString(1, padaria.getLocalDepartamento());
						ps.setString(2, padaria.getLocaRetirada());
						ps.setString(3, padaria.getNomeAtendente());
						ps.execute();
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return false;
			
		}


}
