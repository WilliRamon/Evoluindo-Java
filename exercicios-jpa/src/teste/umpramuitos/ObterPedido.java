package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorId(1L);
		
		pedido.getItens().forEach(item -> {
			System.out.println(item.getQuantidade());
			System.out.println(item.getProduto().getNome());
		});
		
		dao.fechar();
	}
}
