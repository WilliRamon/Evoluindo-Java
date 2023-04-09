package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarPessoa2 {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = FabricaConexao.getConexao();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite parte do nome: ");
		String nomeDigitado = in.nextLine();		

		String query = "SELECT * FROM tb_pessoas WHERE nome LIKE '%?%'";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, nomeDigitado);
		
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		pessoas.forEach(p -> System.out.println(p.getCodigo() + " : " + p.getNome()));
		
		in.close();
		conn.close();
	}
}
