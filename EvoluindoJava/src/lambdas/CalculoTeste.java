package lambdas;

public class CalculoTeste {

	public static void main(String[] args) {
		
		Calculo calculo = new Somar();
		System.out.println("Soma: " + calculo.executar(2, 3));
		
		calculo = new Multiplicar();
		System.out.println("Multiplica��o: " + calculo.executar(2, 3));
	}
}
