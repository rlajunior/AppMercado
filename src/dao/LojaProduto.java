package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import modelo.Produto;
import negocio.Padaria;

public class LojaProduto {
	

	public void salvar(int idProduto, int idLoja) {
		String sql = "INSERT INTO lojaproduto (idproduto,idloja) VALUES (" + idProduto + "," + idLoja + ");";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void remove(int idProduto, int idLoja) {
		String sql = "DELETE FROM lojaproduto WHERE idproduto = "+ idProduto +" AND idloja =" + idLoja ;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
