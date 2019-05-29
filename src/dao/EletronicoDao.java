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
		 
		 String sql = "SELECT * FROM eletronico ORDER BY id";
		 
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
											rs.getString("LocalRetirada"),
											rs.getInt("anoGarantia"),
											rs.getBoolean("possuiGarantia")
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
						PreparedStatement ps = 
								Conexao.obterConexao().prepareStatement(
										"INSERT INTO eletronico "
										+ "(nome, visualizacao, duracao, tipo, membros, arrecadacao) "
										+ "VALUES "
										+ "(?,?,?,?,?,?)"
									);

						ps.setString(1,eletronico.getNome ());
						ps.setFloat(2, eletronico.getPeso());
						ps.setDouble(3, eletronico.getValor());
						ps.setString(4, eletronico.getLocal());
						ps.setString(5, eletronico.getLocaRetirada());
						ps.setInt(6, eletronico.getAnoGarantia());
						ps.setBoolean(7, eletronico.getPossuiGarantia());
						ps.execute();
						
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
					return false;
					
				}

	
	}
