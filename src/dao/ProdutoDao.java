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
			produto.setIdProduto(obterUltimo());
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public  Integer obterUltimo() {

		List<Produto> lista = new ArrayList<Produto>();

		String sql = "SELECT max(idproduto) as idproduto FROM produto;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("idproduto");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;

	}

	public static List<Produto> obterProdutosNaoAssociadosALoja(Integer idLoja) {

		List<Produto> lista = new ArrayList<Produto>();

		String sql = "SELECT * FROM produto p WHERE p.idproduto not in (SELECT pl.idproduto FROM lojaproduto pl where pl.idloja = " + idLoja + ")";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				lista.add(new Produto(rs.getInt("idproduto"),rs.getString("nome") ,rs.getFloat("peso"),rs.getDouble("valor")) {
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static List<Produto> obterProdutosAssociadosALoja(int idLoja) {
		List<Produto> lista = new ArrayList<Produto>();

		String sql = "SELECT * FROM produto p WHERE p.idproduto  in (SELECT pl.idproduto FROM lojaproduto pl where pl.idloja = " + idLoja + ")";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				lista.add(new Produto(rs.getInt("idproduto"),rs.getString("nome") ,rs.getFloat("peso"),rs.getDouble("valor")) {
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
}


	