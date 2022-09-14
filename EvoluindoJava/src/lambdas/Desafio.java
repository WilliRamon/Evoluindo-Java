package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	
	public static void main(String[] args) {
		
		Produto p = new Produto("iPad", 3235.89, 0.13);
		
		/*
		 * 1. A partir do produto calcular o preço real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%) / < 2500 (Isento)
		 * 3. Frete: >= 3000 (100) / < 3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$ 1234,56
		 */
		
		//Preco com desconto
		UnaryOperator<Double> precoDesconto = precoProduto -> precoProduto - (precoProduto * 0.13);
		System.out.println(precoDesconto.apply(p.preco));
		
		//Imposto Municipal
		UnaryOperator<Double> impostoMunicipal = 
				precoProduto -> precoProduto >= 2500.00 ? precoProduto + (precoProduto * 0.085) : precoProduto;
		System.out.println(impostoMunicipal.apply(p.preco));
		
		//Frete
		UnaryOperator<Double> frete = 
				precoProduto -> precoProduto >= 3000.00 ? 100.00 : 50.00;
				
		System.out.println(frete.apply(p.preco));
		
//		//Arredonda
		UnaryOperator<Double> arredondarValor = precoProduto -> Math.round(precoProduto*100.0)/100.0;
		System.out.println(precoDesconto.andThen(arredondarValor).apply(p.preco));
		
		//Formatar Preço
		Function<Double, String> formatarPeco = precoProduto -> "R$ " + precoProduto;
		System.out.println(formatarPeco.apply(p.preco));

		System.out.println("========================");
		
		System.out.println("Preço do produto com desconto, com imposto, arredondado e formatado");
		System.out.println(precoDesconto
				.andThen(impostoMunicipal)
				.andThen(arredondarValor)
				.andThen(formatarPeco)
				.apply(p.preco));
		System.out.println("Preço do Frete");
		System.out.println(precoDesconto
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondarValor)
				.andThen(formatarPeco)
				.apply(p.preco));
	}

}
