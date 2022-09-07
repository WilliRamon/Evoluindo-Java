package exercicios;

import java.util.function.Predicate;

public class PredicadoExercicio02 {
	
	public static void main(String[] args) {
		
		Predicate<Pessoa> isVelho = velho -> velho.getIdade() >= 40;
		Predicate<Pessoa> isBaixo = baixo -> baixo.getAltura() <= 1.62;
		
		Pessoa p1 = new Pessoa("Ramon", 27, 1.80);
		Pessoa p2 = new Pessoa("Gabriela", 23, 1.62);
		Pessoa p3 = new Pessoa("Luzi", 52, 1.60);
		
		System.out.println("O(A) " + p3.getNome() + " é velho(a)? " + isVelho.test(p3));
		System.out.println("O(A) " + p3.getNome() + " também baixa? " + isBaixo.test(p3));
	}


}
