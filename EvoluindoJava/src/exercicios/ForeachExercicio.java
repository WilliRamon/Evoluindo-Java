package exercicios;

import java.util.Arrays;
import java.util.List;

public class ForeachExercicio {

	public static void main(String[] args) {

		List<String> nomes = Arrays.asList("Ramon", "Tamiris", "Ariane");
		
		System.out.println("Tradicional..");
		for(String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println("\nPrimeiro forEach");
		nomes.forEach(nome -> System.out.println(nome));
		
		System.out.println("\nSegundo forEach");
		nomes.forEach((nome) -> {
			System.out.println(nome);
		});
		
		System.out.println("\nMethod Reference...");
		nomes.forEach(System.out::println);

	}
}