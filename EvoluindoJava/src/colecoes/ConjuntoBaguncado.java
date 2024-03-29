package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {

	@SuppressWarnings({ "rawtypes", "unchecked" })	
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2); //double -> Double
		conjunto.add(true); // boolean -> Boolean
		conjunto.add("Teste");
		conjunto.add(1);
		conjunto.add('x');
		
		System.out.println("Tamanho � " + conjunto.size());
		
		conjunto.add("teste");
		System.out.println("Tamanho � " + conjunto.size());
		
		conjunto.add("teste");
		System.out.println("Tamanho � " + conjunto.size());
		
		System.out.println(conjunto.remove("teste"));
		
		System.out.println(conjunto.contains('x')); //M�todo utilizado para verificar se um elemento est� ou n�o dentro de um conjunto.
	
		
		Set nums = new HashSet();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		System.out.println(conjunto);
		
		conjunto.addAll(nums); //Uni�o entre dois conjuntos
		System.out.println(conjunto);
		
		conjunto.retainAll(nums);
		System.out.println(conjunto);
		
		conjunto.clear();
		System.out.println(conjunto);
		
		/*
		 * Por boas pr�ticas, n�o � recomentado utilizar objetos de tipos diferentes
		 * na mesma cole��o. Por�m, por motivo de estudo, desenvolvi dessa forma.
		 */
	}
}
