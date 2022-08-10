package lambdas;

@FunctionalInterface
public interface Calculo {

	public abstract double executar(double a, double b); //Não preciso declarar esse método com public e abstract

	default String legal() {
		return "Legal";
	}
	
	static String muitoLegal() {
		return "muito legal";
	}
}
