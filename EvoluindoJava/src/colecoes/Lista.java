package colecoes;

import java.util.ArrayList;

public class Lista {
	
	public static void main(String[] args) {
		
		ArrayList<Usuario> lista = new ArrayList<>();
		
		Usuario u1 = new Usuario("Ana");
		Usuario u2 = new Usuario();
		u2.setNome("Ramon");
		
		lista.add(u1);
		lista.add(u2);
		lista.add(new Usuario("Willi"));
		lista.add(new Usuario("Leo"));
		lista.add(new Usuario("Tamiris"));
		lista.add(new Usuario("Luzilene"));
		
		System.out.println(lista.get(4));
		
		System.out.println("=======");
		System.out.println(lista.contains(u2));
		System.out.println(lista.contains(new Usuario("Willi")));
		System.out.println(u2.getNome().equals("Ramon"));
		
		for (Usuario u : lista) {
			System.out.println(u.getNome());
		}
	}

}
