package colecoes;

import java.util.HashSet;

public class Hash {

	public static void main(String[] args) {
		
		HashSet<Usuario> usuarios = new HashSet<>();
		
		usuarios.add(new Usuario("Ramon"));
		usuarios.add(new Usuario("Luzilene"));
		usuarios.add(new Usuario("Nilton"));
		usuarios.add(new Usuario("Nilton"));
		usuarios.add(new Usuario("ramon"));
		
		System.out.println(usuarios);
		System.out.println(usuarios.size());
	}
}
