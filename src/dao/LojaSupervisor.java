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

	public void desassociar(String idSupervisor) {
		
		String sql = "UPDATE supervisor set idloja = null Where idsupervisor = " + idSupervisor +"; ";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sqld = "DELETE FROM supervisor WHERE idsupervisor = " + idSupervisor +"; ";

		try {
			PreparedStatement psd = Conexao.obterConexao().prepareStatement(sqld);
			psd.executeUpdate(sqld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}


