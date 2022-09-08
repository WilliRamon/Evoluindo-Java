package lambdas;

public class Produto extends Object{ //Por padr�o, o java sempre herda a classe obje
	
	public String nome;
	public double preco;
	public double desconto;
	
	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public String toString() {
		double precoFinal = preco * (1 - desconto);
		return nome + " tem pre�o de R$ " + precoFinal;
	}
}
