package com.atividadeextensionista.servicos;

import com.atividadeextensionista.entidades.Produto;
import com.atividadeextensionista.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public void cadastrarProduto(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

}
