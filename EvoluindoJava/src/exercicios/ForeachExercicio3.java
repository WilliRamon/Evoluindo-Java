package exercicios;

import java.util.Arrays;
import java.util.List;


public class ForeachExercicio3 {
	
	public static void main(String[] args) {
		
		//Formas que conheço para percorrer listas
		
		List<String> lista = Arrays.asList("Ramon", "Luzi", "Tamiris", "Ariane", "Nilton");
		
		System.out.println("for com contador...");
		for(int x = 0; x < lista.size(); x ++) {
			System.out.println("Olá! Meu nome é " + lista.get(x));
		}
		
		System.out.println("\nforEach com for");
		for(String nome : lista) {
			System.out.println("Olá! Meu nome é " + nome);
		}
		
		System.out.println("\nLambda #1");
		lista.forEach(nome -> System.out.println("Olá! Meu nome é " + nome));
		
		System.out.println("\nLambda #2");
		lista.forEach(nome -> apresentacao(nome));
		
		System.out.println("\nMethod Reference #1");
		lista.forEach(System.out::println);
		
		System.out.println("\nMethod Reference #2");
		lista.forEach(ForeachExercicio3::apresentacao); //Passar o nome da classe
	}
	
	static void apresentacao(String nome) {
		System.out.println("Olá! Meu nome é " + nome);
	}	

}
