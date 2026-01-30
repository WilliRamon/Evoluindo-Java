package br.com.fiap.pet_tech.pet_tech;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos;
    }
    public Produto findById(UUID id){
        var produto = produtoRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return produto;
    }
    public Produto save(Produto produto){
        produto = produtoRepository.save(produto);
        return produto;
    }
    public Produto update(UUID id, Produto produto){
        try{
            Produto produtoAntigo = produtoRepository.getOne(id);
            produto.setId(produtoAntigo.getId());
            produto = produtoRepository.save(produto);

            return produto;
        }catch(EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }
    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }
}
