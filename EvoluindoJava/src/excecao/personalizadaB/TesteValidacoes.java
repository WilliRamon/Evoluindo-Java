package excecao.personalizadaB;

import excecao.Aluno;

public class TesteValidacoes {
	
	public static void main(String[] args) {
		
		try {
			Aluno aluno = new Aluno("Ana", 7);
			Validar.aluno(aluno);
			
			Validar.aluno(null);
		} catch (StringVaziaException e) {
			System.out.println(e.getMessage());
		} catch (NumeroForaIntervaloException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Aluno aluno = new Aluno("Thaís", 10);
			Validar.aluno(aluno);
		} catch (StringVaziaException e) {
			e.printStackTrace();
		} catch (NumeroForaIntervaloException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fim :)");
	}

}
