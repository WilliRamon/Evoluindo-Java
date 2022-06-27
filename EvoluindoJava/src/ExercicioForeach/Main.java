package ExercicioForeach;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Lista> listaArray = new ArrayList<>();
		
		listaArray.add(new Lista("Willi", 10, 8.0, 7, 4));
		listaArray.add(new Lista("Ramon", 7.5, 8.0, 5.5, 10));
		listaArray.add(new Lista("Ramon", 8, 8.8, 7, 10));
		
		for(Lista lista : listaArray) {
			System.out.println(lista);
		}
	}
}
