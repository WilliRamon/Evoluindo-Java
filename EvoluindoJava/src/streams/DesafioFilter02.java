package streams;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter02 {
	
	public static void main(String[] args) {
		
		/*
		 * 1. Desconto maior que 30%
		 * 2. Frete gratis
		 * 3. Saida - Nome do produto, preço dele e a frase "Super promoção"
		 */
		
		ArrayList<Produto02> produtos = new ArrayList<>();
		produtos.add(new Produto02("Notebook", 4500.50, 0.35, 0.0));
		produtos.add(new Produto02("Monitor", 1120, 0.13, 20));
		produtos.add(new Produto02("Mouse", 115.45, 0, 10));
		produtos.add(new Produto02("Abajur", 145.34, 0, 0));
		produtos.add(new Produto02("SmartPhone", 4950, 0.40, 0));
		produtos.add(new Produto02("Mouse-Pad", 49, 0, 15));
		
		Predicate<Produto02> isDesconto = produto -> produto.getDesconto() >= 0.3;
		Predicate<Produto02> isFreteGratis = produto -> produto.getFrete() == 0;
		Function<Produto02, String> fraseSaida = 
				p -> "O " + p.getNome() + " está com uma super promoção! De " + 
			    p.getPreco() + " para " + (p.getPreco() - p.getPreco()*p.getDesconto());
		
		produtos.stream()
			.filter(isDesconto)
			.filter(isFreteGratis)
			.map(fraseSaida)
			.forEach(System.out::println);
	}

}
