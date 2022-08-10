package lambdas;

@FunctionalInterface
public interface Calculo {

	public abstract double executar(double a, double b); //N�o preciso declarar esse m�todo com public e abstract

	default String legal() {
		return "Legal";
	}
	
	static String muitoLegal() {
		return "muito legal";
	}
}
