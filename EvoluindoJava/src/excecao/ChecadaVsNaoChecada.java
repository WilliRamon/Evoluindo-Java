package excecao;

public class ChecadaVsNaoChecada {
	
	public static void main(String[] args) {
		
		//O Try/catch é opcional nessa situação
		geraErro1();
		
		try {
			geraErro2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Fim!!");
		
	}
	
	//Exceção NÃO checada ou NÃO verificada
	static void geraErro1(){
		throw new RuntimeException("Ocorreu um erro bem legal #01!");
	}
	
	//Exceção checada ou  verificada
	static void geraErro2() throws Exception{
		throw new Exception("Ocorreu um erro bem legal #02!");
	}
}
