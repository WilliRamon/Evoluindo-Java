package exercicios;

import java.util.function.Function;

public class FuncaoExercicio01 {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Ramon", 27, 1.80);
		Pessoa p2 = new Pessoa("Gabriela", 23, 1.62);
		Pessoa p3 = new Pessoa("Luzi", 52, 1.60);
		
		Function<Pessoa, Boolean> sobreIdade = idade -> idade.getIdade() >= 40 ? true : false;
		
		Function<Boolean, String> perguntaIdade = valor -> "É velho? Resposta: " + valor;
				
		System.out.println(
				sobreIdade
				.andThen(perguntaIdade)
				.apply(p1)
				);
	}
}
