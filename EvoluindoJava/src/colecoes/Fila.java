package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
	
	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<>();
		
		//Offer e Add -> adicionam elementros na fila
		//Diferen�a � o comportamento quando a fila est� cheia!
		fila.add("Ana");
		fila.offer("Bia");
		fila.add("Carlos"); //Retorna uma exce��o
		fila.offer("Daniel"); //Retorna false
		fila.add("Rafaela");
		fila.offer("Gui");
		
		/*
		 * Peek e Element -> obter o pr�ximo elemento
		 * da fila
		 * 
		 * A diferen�a entre eles ocorram quando a fila est� vazia
		 */
		
		System.out.println(fila.peek()); //Retorna null
		System.out.println(fila.peek());
		System.out.println(fila.element()); //Lan�a uma exce��o
		System.out.println(fila.element());
		
		
		/*
		 * Poll e Remove -> obter o pr�ximo elemento
		 * da fila e remove!
		 * 
		 * Diferen�a � o comportamento quando est� vazia
		 */
		System.out.println(fila.poll());
		System.out.println(fila.remove());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.remove());
		
		
		//fila.size();
		//fila.clear();
		//fila.isEmpty();
		//fila.contains(...);
	}

}
