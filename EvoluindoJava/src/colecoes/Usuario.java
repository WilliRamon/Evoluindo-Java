package colecoes;

import java.util.Objects;

public class Usuario {

	private String nome;
	
	public Usuario() {};
	
	public Usuario(String nome) {
		this.setNome(nome);
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nome, other.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
