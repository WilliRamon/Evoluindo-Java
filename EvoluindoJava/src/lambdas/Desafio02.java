package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio02 {
	
	public static void main(String[] args) {
		
		/*
		 * 1. A partir do produto calcular o preço real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%) / < 2500 (Isento)
		 * 3. Frete: >= 3000 (100) / < 3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$ 1234,56
		 */
		
		
		
		Function<Produto, Double> precoFinal = 
				produto -> produto.preco * (1 - produto.desconto);
		UnaryOperator<Double> impostoMunicipal = 
				precoProduto -> precoProduto >= 2500.00 ? precoProduto * 1.085 : precoProduto;
		UnaryOperator<Double> frete = 
				precoProduto -> precoProduto >= 3000 ? precoProduto + 100.00 : precoProduto + 50;
		UnaryOperator<Double> arredondar =
				precoProduto -> Math.round(precoProduto*100.0)/100.0;
		Function<Double, String> formatar =
				precoProduto -> ("R$" + precoProduto).replace(".", ",");
		
		Produto p = new Produto("iPad", 3235.89, 0.13);
		String preco = precoFinal
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(p);
		
		System.out.println("O preço final é " + preco);
		
	}

}
