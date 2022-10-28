package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DesafioMap02 {
	
	public static void main(String[] args) {
		
		/*
		 * 1. N�mero para string bin�ria... 6 => "110"
		 * 2. Inverter a string... "110" => "011"
		 * 3. Converter de volta para inteiro => "011" => 3
		 */
		
		//INTERFACES FUNCIONAIS
		Consumer<String> printStr = System.out::println; 
		Consumer<Integer> printInt = System.out::println;
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		nums.stream()
		.map(bin -> Integer.toBinaryString(bin))
		.map(inver -> new StringBuilder(inver).reverse().toString())
		.map(rtnInt -> Integer.parseInt(rtnInt, 2)).forEach(printInt);
	}

}
