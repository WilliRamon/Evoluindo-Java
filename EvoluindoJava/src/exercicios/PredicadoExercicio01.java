package exercicios;

import java.util.function.Predicate;

import lambdas.Produto;

public class PredicadoExercicio01 {
	
	public static void main(String[] args) {
		
		Predicate<Produto> isNovo = 
				item -> item.preco >= 750.90;
		
		Produto produto = new Produto("Notebook", 3893.89, 0.85);
		System.out.println(isNovo.test(produto));
		
		
		System.out.println("===============");
		
		
		
		
	}

}
