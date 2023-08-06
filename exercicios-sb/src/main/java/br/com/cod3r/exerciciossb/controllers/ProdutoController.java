package br.com.cod3r.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome, @RequestParam double preco,
											@RequestParam double desconto) {
		Produto produto = new Produto(nome, preco, desconto);
		produtoRepository.save(produto);
		return produto;
	}
	
	@PostMapping("/objeto/produto")
	public @ResponseBody Produto novoProduto(Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@PostMapping("/responseEntity/requestParam")
	public ResponseEntity<Produto> novoProdutoResponseEntity(@RequestParam String nome) {
		Produto produto = new Produto(nome);
		 return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PostMapping("/responseEntity")
	public ResponseEntity<Produto> novoProdutoTeste(@RequestBody Produto produto) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
}
