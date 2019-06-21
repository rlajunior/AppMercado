package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Loja;
import negocio.Supervisor;

public class LojaSupervisor {

	public boolean remove(int idLoja) {

		String sql = "INSERT INTO lojaproduto (idpadaria, localdepartamento, localretirada, nomeatendente) VALUES );" + idLoja;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void salvar(int idsupervisor, int idLoja) {
		String sql = "UPDATE supervisor set idloja = "+ idLoja +" Where idsupervisor = " + idsupervisor +"; ";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Object obterNome(int idloja) {

		List<Supervisor> lista = new ArrayList<Supervisor>();

		String sql = "SELECT * FROM supervisor Where idloja = " + idloja +";";

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


