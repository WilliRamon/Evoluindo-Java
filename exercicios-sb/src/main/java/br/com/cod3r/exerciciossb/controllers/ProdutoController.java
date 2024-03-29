package br.com.cod3r.exerciciossb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}

	@GetMapping("/generation")
	public ResponseEntity<Iterable<Produto>> obterProdutosGen() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterProduto(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@GetMapping("/generation/{id}")
	public ResponseEntity<Optional<Produto>> obterProdutoGen(@PathVariable int id) {
		return ResponseEntity.ok(produtoRepository.findById(id));
	}
	
	@GetMapping("/pagina/{numeroPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 2);
		return produtoRepository.findAll(page);
	}

	@GetMapping("/pagina/quantidade/{numeroPagina}/{qtdPagina}")
	public Iterable<Produto> obterProdutosPorPaginaEQuantidade(@PathVariable int numeroPagina,
			@PathVariable int qtdPagina){
		if(qtdPagina >= 5) qtdPagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		return produtoRepository.findAll(page);
	}

	@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome, @RequestParam double preco,
											@RequestParam double desconto) {
		Produto produto = new Produto(nome, preco, desconto);
		produtoRepository.save(produto);
		return produto;
	}
	
	@PostMapping("/objeto/produto")
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@PostMapping("/responseEntity/requestParam")
	public ResponseEntity<Produto> novoProdutoResponseEntity(@Valid @RequestParam String nome) {
		Produto produto = new Produto(nome);
		 return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PostMapping("/responseEntity")
	public ResponseEntity<Produto> novoProdutoTeste(@Valid @RequestBody Produto produto) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@PutMapping("/generation")
	public ResponseEntity<Produto> alterarProdutoGen(@Valid @RequestBody Produto produto) {
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Posso usar o mesmo métodos para duas funções HTTP
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@DeleteMapping("/{id}")
	public void exluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	@DeleteMapping("/generation/{id}")
	public ResponseEntity<?> exluirProdutoGen(@PathVariable int id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
