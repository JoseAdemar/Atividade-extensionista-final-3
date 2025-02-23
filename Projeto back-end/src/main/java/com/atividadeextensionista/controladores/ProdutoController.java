package com.atividadeextensionista.controladores;

import com.atividadeextensionista.entidades.Produto;
import com.atividadeextensionista.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public void cadastrarProduto(@RequestBody List<Produto> produtos) {
        produtoService.cadastrarProduto(produtos);
    }

}
