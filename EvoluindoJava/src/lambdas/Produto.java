package lambdas;

public class Produto extends Object{ //Por padrão, o java sempre herda a classe obje
	
	public String nome;
	public double preco;
	public double desconto;
	
	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
}
