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
	
	 public static Object obterlista() {
		 
		 List<Produto> lista = new ArrayList<Produto>();
		 
		 String sql = "SELECT * FROM eletronico e inner join produto p on e.idproduto=p.id ORDER BY e.id;";
		 
				 try {
						PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()){
							lista.add(
									new Eletronico(
											rs.getInt("id"), 
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
										+ "(local, localretirada, anogarantia, possuigarantia, idproduto ) "
										+ "VALUES "
										+ "(?,?,?,?,?)"
									);

						ps.setString(1, eletronico.getLocal());
						ps.setString(2, eletronico.getLocaRetirada());
						ps.setInt(3, eletronico.getAnoGarantia());
						ps.setBoolean(4, eletronico.isPossuiGarantia());
						ps.setInt(5, produtoSalvo.getId());
						ps.execute();
						
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
					return false;
					
				}

	
	}
