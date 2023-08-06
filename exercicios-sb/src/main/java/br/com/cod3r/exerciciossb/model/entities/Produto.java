package br.com.cod3r.exerciciossb.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	private int id;
	
	@Column(name = "nome_produto", length = 200, nullable = false)
	private String nome;
}
