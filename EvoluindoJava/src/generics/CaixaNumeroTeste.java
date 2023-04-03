package generics;

public class CaixaNumeroTeste {
	
	public static void main(String[] args) {
		
		CaixaNumero<Double> caixaA = new CaixaNumero<>();
		caixaA.guardar(2.4);
		
		var coisaA = caixaA.abrir();
		System.out.println(coisaA);
	}

}
