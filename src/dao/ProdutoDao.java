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
					.prepareStatement("INSERT INTO produto " + "(nome, peso, valor ) " + "VALUES " + "(?,?,?,?)");
			ps.setInt(1, produto.getIdProduto());
			ps.setString(2, produto.getNome());
			ps.setFloat(3, produto.getPeso());
			ps.setDouble(4, produto.getValor());
			ps.execute();
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

}