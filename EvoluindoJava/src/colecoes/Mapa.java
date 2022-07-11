package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {

	public static void main(String[] args) {
		
		Map<Integer, String> usuarios = new HashMap<>();
		usuarios.put(1, "Ramon");
		usuarios.put(2, "Willi");
		usuarios.put(3, "Ariane");
		usuarios.put(4, "Luzilene");
		usuarios.put(5, "Tamiris");
		
		System.out.println(usuarios.size());
		System.out.println(usuarios.isEmpty());
		
		System.out.println(usuarios.keySet());
		System.out.println(usuarios.values());
		System.out.println(usuarios.entrySet());
		
		System.out.println(usuarios.get(2));
		
		System.out.println("===============");
		
		for(int chave : usuarios.keySet()) {
			System.out.print(chave + " ");
		}
		
		for(String valor : usuarios.values()) {
			System.out.println(valor);
		}
		
		for(Entry<Integer, String> registro : usuarios.entrySet()) {
			System.out.print(registro.getKey() + " ");
			System.out.println(registro.getValue());
		}
	}
}
