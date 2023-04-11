package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class DesafioAtualizarRegistroService {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner in = new Scanner(System.in);
		DesafioAtualizarRegistroDao dao = new DesafioAtualizarRegistroDao();
		
		System.out.println("Digite um código para consultar: ");
		int codigoDigitado = in.nextInt();
		
		Pessoa pessoa = dao.buscarResgitros(codigoDigitado);
		
		in.nextLine();
		if(pessoa != null) {
			System.out.println("Nome encontrado!");
			System.out.println(pessoa.getCodigo() + " : " + pessoa.getNome());
			
			System.out.println("Digite o novo nome: ");
			String nomeDigitado = in.nextLine();
			
			dao.atualizarRegistros(codigoDigitado, nomeDigitado);
			
			System.out.println("Atualização feita!!!");
		}else {
			System.out.println("Nenhum registro encontrado.");
		}
		
		in.close();
	}

}
