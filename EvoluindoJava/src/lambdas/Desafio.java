package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	
	public static void main(String[] args) {
		
		/*
		 * 1. A partir do produto calcular o preço real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%) / < 2500 (Isento)
		 * 3. Frete: >= 3000 (100) / < 3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$ 1234,56
		 */
		
		Produto p = new Produto("iPad", 3235.89, 0.13);
		
		UnaryOperator<Double> precoDesconto = 
				precoProduto -> precoProduto - (precoProduto * 0.13);
		UnaryOperator<Double> impostoMunicipal = 
				precoProduto -> precoProduto >= 2500.00 ? precoProduto + (precoProduto * 0.085) : precoProduto;
		UnaryOperator<Double> frete = 
				precoProduto -> precoProduto >= 3000.00 ? precoProduto + 100.00 : precoProduto + 50.00;
		UnaryOperator<Double> arredondarValor = 
				precoProduto -> Math.round(precoProduto*100.0)/100.0;		
		Function<Double, String> formatarPeco = 
				precoProduto -> "R$ " + precoProduto;
		UnaryOperator<String> fraseSaida = 
				precoProduto -> "O preço final do produto é " + precoProduto;
		
		String valorFinal = precoDesconto
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondarValor)
				.andThen(formatarPeco)
				.andThen(fraseSaida)
				.apply(p.preco);
		
		System.out.println(valorFinal);

	}

}
