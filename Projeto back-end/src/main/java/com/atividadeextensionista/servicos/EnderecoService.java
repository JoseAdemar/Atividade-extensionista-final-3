package com.atividadeextensionista.servicos;

import com.atividadeextensionista.entidades.Endereco;
import com.atividadeextensionista.entidades.EnderecoDTO;
import com.atividadeextensionista.repositorios.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.save(endereco);
        return enderecoDTO;
    }

    public Endereco buscaEnderecoPorCep (String cep) {
        return enderecoRepository.findByCep(cep);
    }
}
