package br.com.cod3r.exerciciossb.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	
}
