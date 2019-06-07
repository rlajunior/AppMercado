package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Eletronico;

public class EletronicoDao {
	
	
		public boolean remove (int id) {
				
				String sql = "DELETE FROM eletronico WHERE ideletronico = " + id;
				String sql2 = "DELETE FROM produto WHERE idproduto = " +  id;
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
			PreparedStatement ps1 = Conexao.obterConexao().prepareStatement(sql2);
			ps.executeUpdate(sql2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}	
		public static Object obterlista() {
		 
		 List<Produto> lista = new ArrayList<Produto>();
		 
		 String sql = "SELECT * FROM eletronico e inner join produto p on p.idproduto=e.ideletronico ORDER BY e.ideletronico;";
		 
				 try {
						PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()){
							lista.add(
									new Eletronico(
											rs.getInt("idproduto"), 
											rs.getString("nome"),
											rs.getFloat("peso"),
											rs.getDouble("valor"),
											rs.getString("local"),
											rs.getString("localretirada"),
											rs.getInt("anogarantia"),
											rs.getBoolean("possuigarantia")
											)
								);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return lista;
				}

		public static boolean salvar(Eletronico eletronico) {
			try {

				
				ProdutoDao pdao = new ProdutoDao();
				
				Produto produtoSalvo = pdao.salvar(eletronico);
				
				
				PreparedStatement ps = 
						Conexao.obterConexao().prepareStatement(
								"INSERT INTO eletronico "
								+ "(ideletronico, local, localretirada, anogarantia, possuigarantia) "
								+ "VALUES "
								+ "(?,?,?,?,?)"
							);
				ps.setInt(1, produtoSalvo.getIdProduto());
				ps.setString(2, eletronico.getLocal());
				ps.setString(3, eletronico.getLocaRetirada());
				ps.setInt(4, eletronico.getAnoGarantia());
				ps.setBoolean(5, eletronico.isPossuiGarantia());
				ps.execute();
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return false;
			
		}


}
