package exerciciostreams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExercicioIterator01 {
	
	public static void main(String[] args) {
	
		List<Integer> numeros = Arrays.asList(21, 33, 45, 12, 5);
		
		Iterator<Integer> it = numeros.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
