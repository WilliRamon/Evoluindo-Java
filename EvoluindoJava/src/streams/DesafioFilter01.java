package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter01 {
	
	public static void main(String[] args) {
		
		Livro l1 = new Livro("Naruto", "Anime", true);
		Livro l2 = new Livro("A sutil arte de ligar o f*da-se", "Autoajuda", true);
		Livro l3 = new Livro("Harry Potter", "Fantasia", false);
		Livro l4 = new Livro("One Piece", "Anime", true);
		Livro l5 = new Livro("Homem de Ferro", "Comic", false);
		Livro l6 = new Livro("Capitão América", "Comic", true);
		Livro l7 = new Livro("Homem Aranha", "Comic", true);
		
		List<Livro> livros = Arrays.asList(l1, l2, l3, l4, l5, l6, l7);
		
		Predicate<Livro> isAnime = livro -> livro.genero.equals("Anime");
		Predicate<Livro> isComic = livro -> livro.genero.equals("Comic");
		Predicate<Livro> isAutoajuda = livro -> livro.genero.equals("Autoajuda");
		Predicate<Livro> isFantasia = livro -> livro.genero.equals("Fantasia");
		Predicate<Livro> isEstoque = livro -> livro.estoque;
		Function<Livro, String> livroDisponivel = livro -> "O livro " + livro.nome + " está disponivel";
		
		livros.stream()
		.filter(isAnime)
		.filter(isEstoque)
		.map(livroDisponivel)
		.forEach(System.out::println);
		
	}

}
