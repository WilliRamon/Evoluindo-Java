package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n -> n + 2;
		UnaryOperator<Integer> vezesDois = n -> n * 2;
		UnaryOperator<Integer> aoQuadrado = n -> n * n;
		
		int resultado1 = maisDois
				.andThen(vezesDois)
				.andThen(aoQuadrado)
				.apply(0);
		
		System.out.println(resultado1);
		//andThen traz a ideia de "E ent�o". Executando de cima para baixo
		
		int resultado2 = maisDois
				.compose(vezesDois)
				.compose(aoQuadrado)
				.apply(0);
		System.out.println(resultado2);
		//compose traz a ideia de "Antes de". Executando de baixo para cima
	}

}
