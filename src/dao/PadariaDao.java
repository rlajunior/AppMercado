package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Padaria;


public class PadariaDao {
	
	 public static Object obterlista() {
		 
		 List<Produto> lista = new ArrayList<Produto>();
		 
		 String sql = "SELECT * FROM padaria pa inner join produto p on pa.id=p.id ORDER BY p.id";
		 
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
											rs.getString("localDepartmento"),
											rs.getString("LocalRetirada"),
											rs.getString("nomeAtendente")
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
						PreparedStatement ps = 
								Conexao.obterConexao().prepareStatement(
										"INSERT INTO padaria "
										+ "(nome, peso, valor, localDepartmento, LocalRetirada, nomeAtendente) "
										+ "VALUES "
										+ "(?,?,?,?,?,?)"
									);

						ps.setString(1,padaria.getNome ());
						ps.setFloat(2, padaria.getPeso());
						ps.setDouble(3, padaria.getValor());
						ps.setString(4, padaria.getLocalDepartamento());
						ps.setString(5, padaria.getLocaRetirada());
						ps.setString(5, padaria.getNomeAtendente());
						ps.execute();
						
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
					return false;
					
				}

	
	}
