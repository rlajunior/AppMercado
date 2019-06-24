package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Eletronico;
import negocio.Padaria;

public class PadariaDao {

	public boolean remove(int id) {

		String sql = "DELETE FROM padaria WHERE idpadaria = " + id;
		String sql2 = "DELETE FROM produto WHERE idproduto = " + id;
		String sql3 = "DELETE FROM lojaproduto WHERE idproduto = " + id;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
			PreparedStatement ps1 = Conexao.obterConexao().prepareStatement(sql2);
			PreparedStatement ps2 = Conexao.obterConexao().prepareStatement(sql3);
			ps.executeUpdate(sql3);
			ps.executeUpdate(sql2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static Object obterlista() {

		List<Produto> lista = new ArrayList<Produto>();

		String sql = "SELECT * FROM padaria pa inner join produto p on pa.idpadaria=p.idproduto ORDER BY pa.idpadaria";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Padaria(rs.getInt("idproduto"), rs.getString("nome"), rs.getFloat("peso"),
						rs.getDouble("valor"), rs.getString("localdepartamento"), rs.getString("Localretirada"),
						rs.getString("nomeatendente")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static boolean salvar(Padaria padaria) {
		try {

			ProdutoDao pdao = new ProdutoDao();

			Produto produtoSalvo = pdao.salvar(padaria);

			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT INTO padaria "
					+ "(idpadaria, localdepartamento, localretirada, nomeatendente) " + "VALUES " + "(?,?,?,?)");
			ps.setInt(1, produtoSalvo.getIdProduto());
			ps.setString(2, padaria.getLocalDepartamento());
			ps.setString(3, padaria.getLocaRetirada());
			ps.setString(4, padaria.getNomeAtendente());
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}