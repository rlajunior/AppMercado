package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Loja;

public class LojaDao {
	
	public static Object obterlista() {

		List<Loja> lista = new ArrayList<Loja>();

		String sql = "SELECT * FROM loja ORDER BY idloja";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Loja(rs.getInt("idloja"),
						rs.getString("nome"), 
						rs.getString("endereco"), 
						rs.getString("bairro")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static boolean salvar(Loja  loja) {
		try {

	
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT INTO loja "
					+ "(nome, endereco, bairro) " + "VALUES " + "(?,?,?)");
			ps.setString(1, loja.getNome());
			ps.setString(2, loja.getEndereco());
			ps.setString(3, loja.getBairro());
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}


