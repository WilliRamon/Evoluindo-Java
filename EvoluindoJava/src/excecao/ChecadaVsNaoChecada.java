package excecao;

public class ChecadaVsNaoChecada {
	
	public static void main(String[] args) {
		
		//O Try/catch � opcional nessa situa��o
		geraErro1();
		
		try {
			geraErro2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Fim!!");
		
	}
	
	//Exce��o N�O checada ou N�O verificada
	static void geraErro1(){
		throw new RuntimeException("Ocorreu um erro bem legal #01!");
	}
	
	//Exce��o checada ou  verificada
	static void geraErro2() throws Exception{
		throw new Exception("Ocorreu um erro bem legal #02!");
	}
}
