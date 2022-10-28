package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
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
		Consumer<Integer> printInt = System.out::println;
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Stream<String> binario = nums.stream().map(bin -> Integer.toBinaryString(bin));
		
		Stream<String> invertido = binario.map(inver -> new StringBuilder(inver).reverse().toString());
		
		Stream<Integer> retornaInteiro = invertido.map(rtnInt -> Integer.parseInt(rtnInt, 2));
		
		
		//binario.forEach(printStr);
		System.out.println("==========");
		//invertido.forEach(printStr);
		System.out.println("==========");
		retornaInteiro.forEach(printInt);
	
	}
	
//FORMAS COMPRIDAS DE EXECUTAR ESSE EXERCICIO.
//		nums.stream().map(bin -> Integer.toBinaryString(bin)).forEach(bin2 -> System.out.println(bin2));
	
//		Stream<String> binario = nums.stream().map(bin -> Integer.toBinaryString(bin));
//		binario.forEach(bin -> System.out.println(bin));
}