package arrays;

import java.util.Scanner;

public class DesafioArray {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int tamanhoLista = 0;
		double somaNotas = 0;
		
		System.out.println("Quantas notas você quer inserir?");
		tamanhoLista = ler.nextInt();
		
		double[] notas = new double[tamanhoLista];
		
		for(int x = 0; x < notas.length; x++) {
			System.out.println("Digite a nota " + (x + 1));
			notas[x] = ler.nextDouble();
		}
		
		for(double soma : notas) {
			somaNotas += soma;
		}
		
		System.out.println("Media Final: " + somaNotas/tamanhoLista);
		
	}
	
	/*
	 * Esse exercício poderia ser desenvolvido com apenas um FOR,
	 * porém, com o intuito de estudo, criei um FOR iniciando com um contador
	 * e outro com FOREACH
	 */

}
