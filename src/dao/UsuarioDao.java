package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {

	public static boolean validar(Usuario usuario) {

		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}