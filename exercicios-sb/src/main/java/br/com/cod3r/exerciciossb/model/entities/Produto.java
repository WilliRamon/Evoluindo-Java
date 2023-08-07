package br.com.cod3r.exerciciossb.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "O atributo nome_produto é obrigatório e não aceita espaço vazio")
	@Column(name = "nome_produto", length = 200)
	private String nome;
	
//	@Size(max = 12, message = "O atributo preco deve conter no máximo 12 caracteres")
	@Min(0)
	@Column(name = "preco_produto", columnDefinition = "DECIMAL(10,2) DEFAULT '0.00'")
	private double preco;
	
	@Min(0)
	@Max(1)
	private double desconto;
	
	public Produto() {
	
	}

	public Produto(String nome) {
		this.nome = nome;
	}
	
	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco - preco * desconto;
		this.desconto = desconto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
		this.preco =  this.getPreco() - this.getPreco() * desconto;
	}
	
}
