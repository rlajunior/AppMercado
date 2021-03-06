package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Loja;
import negocio.Supervisor;

public class LojaDao {
	
	public static Object obterlista() {

		List<Loja> lista = new ArrayList<Loja>();

		String sql = "SELECT * FROM loja ORDER BY idloja";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Supervisor supervisor = buscaSupervisor(rs);
				
				Integer qtdProdutos = buscaQuantidadeProdutos(rs);
				
				lista.add(new Loja(rs.getInt("idloja"),
						rs.getString("nome"), 
						rs.getString("endereco"), 
						rs.getString("bairro"),supervisor,qtdProdutos));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	private static Integer buscaQuantidadeProdutos(ResultSet rs) throws SQLException {
		String sql = "SELECT COUNT(*) as qtd FROM lojaproduto WHERE idloja = " + rs.getInt("idloja");
		
		PreparedStatement pss = Conexao.obterConexao().prepareStatement( sql);

		ResultSet rss = pss.executeQuery();
	
		
		if(rss.next()) {
			
			return rss.getInt("qtd");

		}
		return 0;
	}

	private static Supervisor buscaSupervisor(ResultSet rs) throws SQLException {
		String sqlSupervisor = "SELECT * FROM supervisor WHERE idloja = " + rs.getInt("idloja");
		
		PreparedStatement pss = Conexao.obterConexao().prepareStatement(sqlSupervisor);

		ResultSet rss = pss.executeQuery();
		
		Supervisor supervisor = null;
		
		if(rss.next()) {
			
			supervisor = new Supervisor();
			supervisor.setNome(rss.getString("nome"));
			supervisor.setIdSupervisor(rss.getInt("idsupervisor"));

		}
		return supervisor;
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

	public static Loja buscarPorId(int parseInt) {

		String sql = "SELECT * FROM loja WHERE idloja = " + parseInt;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			return new Loja(rs.getInt("idloja"),
						rs.getString("nome"), 
						rs.getString("endereco"), 
						rs.getString("bairro"));
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}


