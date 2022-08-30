package exercicios;

import java.util.function.BinaryOperator;

public class InterfacesFuncionais {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> soma = (x, y) -> { return x + y; };
		System.out.println("O resultado da soma é : " + soma.apply(10, 3));
		
		BinaryOperator<Integer> sub = (x, y) -> { return x - y; };
		System.out.println("O resultado da subtração é: " + sub.apply(10, 5));
		
		BinaryOperator<Integer> mult = (x, y) -> { return x * y; };
		System.out.println("O resultado da multiplicação é: " + mult.apply(10, 10));
		
		BinaryOperator<Integer> div = (x, y) -> { return x / y; };
		System.out.println("O resultado da divisão é: " + div.apply(10, 5));

	}

}
