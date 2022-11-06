package streams;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ReduceExercicio02 {

	public static void main(String[] args) {
		
		ArrayList<Aluno> aluno = new ArrayList<>();
		aluno.add(new Aluno("Willi", 10));
		aluno.add(new Aluno("Ramon", 8));
		aluno.add(new Aluno("Sabino", 6));
		aluno.add(new Aluno("Leonidas", 10));
		aluno.add(new Aluno("Luzilene", 11));
		aluno.add(new Aluno("Tamiris", 0));
		
		Function<Aluno, Double> somenteNota = n -> n.nota;
		BinaryOperator<Double> somatoria = (ac, s) -> ac + s;
		
		aluno.stream()
			.map(somenteNota)
			.reduce(somatoria)
			.ifPresent(System.out::println);
		
	}
}
