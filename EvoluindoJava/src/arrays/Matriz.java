package arrays;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int qtdAlunos;
		int qtdNotas;
		double somaNotas = 0;
		
		System.out.println("Quantos alunos há na sala?");
		qtdAlunos = ler.nextInt();
		
		System.out.println("Quantas notas serão digitadas?");
		qtdNotas = ler.nextInt();
		
		double[][] matriz = new double[qtdAlunos][qtdNotas];
		
		for(int x = 0; x < qtdAlunos; x++) {
			for(int y = 0; y < qtdNotas; y++) {
				System.out.println("Digite a nota " + (y+1) + " do aluno " + (x+1));
				matriz[x][y] = ler.nextDouble(); 
				somaNotas += matriz[x][y];
			}
		}
		
		System.out.println("Media da sala: " + (somaNotas/qtdNotas)/qtdAlunos);
		
		

	}

}
