package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesafioAtualizarRegistroDao {
	
	public Pessoa buscarResgitros(int codigoDigitado) throws SQLException {
		
		Connection conn = FabricaConexao.getConexao();
		
		String query = "SELECT * FROM tb_pessoas WHERE codigo = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, codigoDigitado);
		
		ResultSet resultado = stmt.executeQuery();
		
		Pessoa pessoa = new Pessoa();
		while(resultado.next()) {
			pessoa.setCodigo(resultado.getInt("codigo"));
			pessoa.setNome(resultado.getString("nome"));
		}
		conn.close();
		
		return pessoa;
	}
	
	public void atualizarRegistros(int codigoDigitado, String nomeDigitado) throws SQLException {
		
		Connection conn = FabricaConexao.getConexao();

		String query = "UPDATE tb_pessoas SET nome = ? WHERE codigo = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, nomeDigitado);
		stmt.setInt(2, codigoDigitado);
		
		stmt.execute();
		stmt.close();
	}

}
