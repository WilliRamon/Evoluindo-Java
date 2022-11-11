package streams;

import java.util.Objects;

public class Aluno {
	
	final String nome;
	final double nota;
	final boolean bomComportamento;
	
	public Aluno(String nome, double nota) {
		this.nome = nome;
		this.nota = nota;
		this.bomComportamento = true;
	}

	public String toString() {
		return nome + " tem nota " + nota;
	}
}
