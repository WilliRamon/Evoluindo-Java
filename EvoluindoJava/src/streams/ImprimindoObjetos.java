package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimindoObjetos {
	
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Lu", "Gui", "Luca", "Ana");
		
		System.out.println("Usando Foreach...");
		for(String nomes : aprovados) {
			System.out.println(nomes);
		}
		
		System.out.println("\nUsando Iterator...");
		Iterator<String> it = aprovados.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\nUsando Stream...	 ");
		Stream<String> stream = aprovados.stream();
		stream.forEach(System.out::println); //La�o Interno
	}

}
