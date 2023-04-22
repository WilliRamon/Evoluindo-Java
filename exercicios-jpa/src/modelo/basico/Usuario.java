package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private Long id;
//	@Column(name = "nome", nullable = false)
	private String nome;
//	@Transient -> Essa anotações diz que essa atributo não é mapeado e não tem uma coluna equivalente na tabela
	private String email;

	public Usuario() {
		
	}
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
