package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExercicio01 {
	
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		BinaryOperator<Integer> soma = (cont, num) -> cont + num;
				
		//nums.stream().reduce(soma);
		System.out.println(nums.stream().reduce(soma).get());
		
		
		nums.stream()
			.reduce(soma)
			.ifPresent(System.out::println);
		
		System.out.println("=========================");
		Integer total = nums.stream().reduce(soma).get();
		System.out.println(total);
		
	}
}
