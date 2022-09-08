package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor { //Ou Supplier
	
	public static void main(String[] args) {
		
		Supplier<List<String>> umaLista = () -> Arrays.asList("Ramon", "Luzi", "Tamiris", "Ariane");
		
		System.out.println(umaLista.get());
	}

}
