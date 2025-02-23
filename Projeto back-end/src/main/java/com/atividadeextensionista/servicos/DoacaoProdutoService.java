package com.atividadeextensionista.servicos;

import com.atividadeextensionista.entidades.*;
import com.atividadeextensionista.repositorios.DoacaoProdutoRepository;
import com.atividadeextensionista.repositorios.DoacaoRepository;
import com.atividadeextensionista.repositorios.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoacaoProdutoService {

    @Autowired
    private DoacaoProdutoRepository doacaoProdutoRepository;

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void registrarDoacaoProduto(List<DoacaoProdutoDTO> doacaoProdutoDTO) {
        List<DoacaoProduto> doacaoProdutos = doacaoProdutoDTO.stream()
                .map(dto -> {
                    Doacao doacao = doacaoRepository.findById(dto.getDoacaoId())
                            .orElseThrow(() -> new EntityNotFoundException("Doação não encontrada com o ID: " + dto.getDoacaoId()));

                    doacao.setId(dto.getDoacaoId());
                    doacao.getId();

                    Produto produto = produtoRepository.findById(dto.getProdutoId())
                            .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + dto.getProdutoId()));
                    produto.setId(dto.getProdutoId());
                    produto.getId();

                    DoacaoProduto doacaoProduto = new DoacaoProduto();
                    doacaoProduto.setDoacao(doacao);
                    doacaoProduto.setProduto(produto);
                    doacaoProduto.setQuantidade(dto.getQuantidade());
                    return doacaoProduto;
                })
                .collect(Collectors.toList());
        doacaoProdutoRepository.saveAll(doacaoProdutos);
    }

    public List<DoacaoConsultaDTO> obterResumoDoacoes() {
        List<Tuple> result = doacaoProdutoRepository.buscarResumoDoacoes();
        List<DoacaoConsultaDTO> doacoes = new ArrayList<>();

        for (Tuple tuple : result) {
            DoacaoConsultaDTO dto = new DoacaoConsultaDTO(
                    tuple.get("doacaoId", Long.class),
                    tuple.get("totalItens", BigDecimal.class),
                    tuple.get("produtos", String.class),
                    tuple.get("doacaoRecolhida", Boolean.class),
                    tuple.get("nomeDoador", String.class),
                    tuple.get("emailDoador", String.class),
                    tuple.get("telefoneDoador", String.class),
                    tuple.get("cepEndereco", String.class),
                    tuple.get("ufEndereco", String.class),
                    tuple.get("cidade", String.class)
            );
            doacoes.add(dto);
        }
        return doacoes;
    }

    public void updateDoacaoRecolhidaStatus (Long id) {
        doacaoProdutoRepository.updateDoacaoRecolhida(id);
    }
}
