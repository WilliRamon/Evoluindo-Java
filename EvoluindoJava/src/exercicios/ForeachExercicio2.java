package exercicios;

import java.util.ArrayList;

public class ForeachExercicio2 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> notas = new ArrayList<>();
		notas.add(10);
		notas.add(6);
		notas.add(4);
		notas.add(9);
		
		notas.forEach(nota -> {
			System.out.println(nota);
		});
				

	}

}
