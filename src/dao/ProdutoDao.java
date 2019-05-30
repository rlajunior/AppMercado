package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Eletronico;

public class ProdutoDao {

	public Produto salvar(Produto produto) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT INTO produto " + "(nome, peso, valor ) " + "VALUES " + "(?,?,?)");

			ps.setString(1, produto.getNome());
			ps.setFloat(2, produto.getPeso());
			ps.setDouble(3, produto.getValor());

			ps.execute();
			produto.setId(obterUltimo());
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public  Integer obterUltimo() {

		List<Produto> lista = new ArrayList<Produto>();

		String sql = "SELECT max(id) as id FROM produto;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;

	}

}
