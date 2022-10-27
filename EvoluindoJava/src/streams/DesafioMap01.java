package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class DesafioMap01 {
	
	public static void main(String[] args) {
		
		/*
		 * 1. Número para string binária... 6 => "110"
		 * 2. Inverter a string... "110" => "011"
		 * 3. Converter de volta para inteiro => "011" => 3
		 */

		//INTERFACES FUNCIONAIS
		Consumer<String> printStr = System.out::println; 
		//Function<Integer, String> printIntStg = System.out::print;
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		nums.stream().map(bin -> Integer.toBinaryString(bin)).forEach(printStr);
		
		/*
		 * O que deve ser feito...
		 * O erro que está dando é que estou invertendo a list nums direto como String.
		 * O correto é pegar o produto do bin e passar para o inver.
		 * Continuar amanhã
		 */
		nums.stream().map(inver -> new StringBuilder(inver).reverse().toString()).forEach(printStr);
		
		
		
//		String nome = "nome";
//		System.out.println(new StringBuilder(nome).reverse().toString());
//			
	}
	
//FORMAS COMPRIDAS DE EXECUTAR ESSE EXERCICIO.
//		nums.stream().map(bin -> Integer.toBinaryString(bin)).forEach(bin2 -> System.out.println(bin2));
	
//		Stream<String> binario = nums.stream().map(bin -> Integer.toBinaryString(bin));
//		binario.forEach(bin -> System.out.println(bin));
}
