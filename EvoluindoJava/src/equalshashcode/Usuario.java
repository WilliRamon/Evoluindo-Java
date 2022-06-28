package equalshashcode;

public class Usuario {

	private String nome;
	private String email;

	public boolean equals(Object obj) {

		if (obj instanceof Usuario) {
			Usuario outro = (Usuario) obj;

			boolean nomeIgual = outro.getNome().equals(this.getNome());
			boolean emailIgual = outro.getEmail().equals(this.getEmail());

			return nomeIgual && emailIgual;
		}
		else{
			return false;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
