package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.Conexao;
import modelo.Produto;
import negocio.Supervisor;

public class SupervisorDao {

	public Boolean remover(int id) {

		String sql = "DELETE FROM supervisor WHERE idsupervisor = " + id;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static Object obterlista() {

		List<Supervisor> lista = new ArrayList<Supervisor>();

		String sql = "SELECT * FROM supervisor ORDER BY idsupervisor";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Supervisor(rs.getInt("idsupervisor"), rs.getString("nome"), rs.getString("email"),
						rs.getInt("anoentrada"), rs.getBoolean("ativo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static boolean salvar(Supervisor Supervisor) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT INTO supervisor " + "(nome, email, anoentrada, ativo) " + "VALUES " + "(?,?,?,?)");

			ps.setString(1, Supervisor.getNome());
			ps.setString(2, Supervisor.getEmail());
			ps.setInt(3, Supervisor.getAnoEntrada());
			ps.setBoolean(4, Supervisor.isAtivo());
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
	
	public static List<Supervisor> obterSupervisorAssociadosALoja(int idLoja) {
		List<Supervisor> lista = new ArrayList<Supervisor>();

		String sql = " SELECT * FROM supervisor where idloja = " + idLoja +"; ";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Supervisor(rs.getInt("idsupervisor"), rs.getString("nome"), rs.getString("email"),
						rs.getInt("anoentrada"), rs.getBoolean("ativo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	
	public static Object obterSupervisorNaoAssociadosALoja() {

		List<Supervisor> lista = new ArrayList<Supervisor>();

		String sql = " SELECT * FROM supervisor where idloja is NULL;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Supervisor(rs.getInt("idsupervisor"), rs.getString("nome"), rs.getString("email"),
						rs.getInt("anoentrada"), rs.getBoolean("ativo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
