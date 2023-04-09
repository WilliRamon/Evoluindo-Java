package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultarPessoas1 {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "SELECT * FROM tb_pessoas";
		
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		while(resultado.next()){
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		pessoas.forEach(pessoa -> System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome()));
		
		stmt.close();
		conexao.close();
	}

}
