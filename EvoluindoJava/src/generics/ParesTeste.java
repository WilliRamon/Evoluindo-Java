package generics;

public class ParesTeste {
	
	public static void main(String[] args) {
		
		Pares<Integer, String> resultadoConcurso = new Pares<>();
		
		resultadoConcurso.adicionar(1, "Willi");
		resultadoConcurso.adicionar(2, "Ramon");
		resultadoConcurso.adicionar(3, "Luzi");
		resultadoConcurso.adicionar(4, "Tamiris");
		resultadoConcurso.adicionar(2, "Léo");
		
		System.out.println(resultadoConcurso.getValor(2));
	}

}
