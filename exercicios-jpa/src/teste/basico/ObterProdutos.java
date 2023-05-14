package teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {

	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.obterTodos();
		
		produtos.forEach(produto -> {
			System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome());
		});
		
		double precoTotal = produtos
				.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (total, precoAtual) -> total + precoAtual)
				.doubleValue(); // 
		System.out.println("O valor total � R$ " + precoTotal);
		
		dao.fechar();
	}
}
