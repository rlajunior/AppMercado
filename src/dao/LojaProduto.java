package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import modelo.Produto;
import negocio.Padaria;

public class LojaProduto {
	
	
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

	public void salvar(int idPRoduto, int idLoja) {
		String sql = "INSERT INTO lojaproduto (idproduto,idloja) VALUES (" + idPRoduto + "," + idLoja + ");";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
