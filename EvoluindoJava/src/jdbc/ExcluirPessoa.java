package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o código para exluir: ");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM tb_pessoas WHERE codigo = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		
		if(stmt.executeUpdate() > 0) { // Esse comando retorna a quantidade de linhas que foram afetadas pelo meu comando
			System.out.println("Pessoa excluida com sucesso!");
		}else {
			System.out.println("Nada feito");
		}
		
		conexao.close();
		entrada.close();
	}

}
