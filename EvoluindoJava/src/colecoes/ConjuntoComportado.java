package colecoes;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {

	public static void main(String[] args) {
		
		HashSet<String> listaAprovados = new HashSet<>();
		listaAprovados.add("Tamiris");
		listaAprovados.add("Willi");
		listaAprovados.add("Ramon");
		listaAprovados.add("Leônidas");
		listaAprovados.add("Ariane");
		
		for (String candidato : listaAprovados) {
			System.out.println(candidato);
		}
		
		System.out.println(listaAprovados.toString());
		
		
		System.out.println("========================");
		
		//O TreeSet, permite a ordenação
		SortedSet<String> lista = new TreeSet<>();
		lista.add("Tamiris");
		lista.add("Willi");
		lista.add("Ramon");
		lista.add("Leônidas");
		lista.add("Ariane");
		
		for (String candidato : lista) {
			System.out.println(candidato);
		}
		
		System.out.println("================");
		
		HashSet<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(120);
		nums.add(6);
		
		for (int n : nums) {
			System.out.println(n);
		}
	}
}
