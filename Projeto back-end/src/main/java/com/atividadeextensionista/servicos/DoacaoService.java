package com.atividadeextensionista.servicos;

import com.atividadeextensionista.entidades.*;
import com.atividadeextensionista.repositorios.DoacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private DoacaoProdutoService doacaoProdutoService;


    public void registrarDoacao(DoacaoDTO doacaoDTO) {
        Doador doador = doadorService.encontrarDoadorPorCpf(doacaoDTO.doador().getCpf());
        if (doador != null) {
            doador.getEndereco().getId();
            doador.getId();
            Doacao doacao = new Doacao();
            doacao.setDoador(doador);
            doacao.setDoacaoRecolhida(doacaoDTO.doacaoRecolhida());

            doacaoRepository.save(doacao);
            Long doacaoId = doacao.getId();

            List<DoacaoProduto> doacaoProdutos = new ArrayList<>();
            for (DoacaoProdutoDTO dto : doacaoDTO.doacaoProduto()) {
                dto.setDoacaoId(doacaoId);
                dto.setProdutoId(dto.getProdutoId());
                dto.setQuantidade(dto.getQuantidade());
                DoacaoProduto doacaoProduto = new DoacaoProduto();
                BeanUtils.copyProperties(dto, doacaoProduto);
                doacaoProdutos.add(doacaoProduto);  // Adiciona o objeto convertido na lista
            }
            doacaoProdutoService.registrarDoacaoProduto(doacaoDTO.doacaoProduto());

        } else {
            Doador doador1 = new Doador();
            BeanUtils.copyProperties(doacaoDTO.doador(), doador1);
            doadorService.cadastrarDoador(doador1);
            Doador doador2 = doadorService.encontrarDoadorPorCpf(doacaoDTO.doador().getCpf());
            if (doador2 != null) {
                Doacao doacao = new Doacao();
                doacao.setDoador(doador2);
                List<DoacaoProduto> doacaoProdutos = new ArrayList<>();
                BeanUtils.copyProperties(doacaoDTO.doacaoProduto(), doacaoProdutos);

                doacao.setDoacaoProdutos(doacaoProdutos);
                doacaoRepository.save(doacao);
                Long doacaoId = doacao.getId();

                List<DoacaoProduto> doacaoProdutos2 = new ArrayList<>();
                for (DoacaoProdutoDTO dto : doacaoDTO.doacaoProduto()) {
                    dto.setDoacaoId(doacaoId);
                    dto.setProdutoId(dto.getProdutoId());
                    dto.setQuantidade(dto.getQuantidade());
                    DoacaoProduto doacaoProduto = new DoacaoProduto();
                    BeanUtils.copyProperties(dto, doacaoProduto);
                    doacaoProdutos2.add(doacaoProduto);  // Adiciona o objeto convertido na lista
                }
                doacaoProdutoService.registrarDoacaoProduto(doacaoDTO.doacaoProduto());
            }
        }

    }

}

