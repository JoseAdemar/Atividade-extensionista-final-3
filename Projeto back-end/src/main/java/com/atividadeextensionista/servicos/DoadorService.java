package com.atividadeextensionista.servicos;

import com.atividadeextensionista.entidades.Doacao;
import com.atividadeextensionista.entidades.Doador;
import com.atividadeextensionista.entidades.Endereco;
import com.atividadeextensionista.entidades.EnderecoDTO;
import com.atividadeextensionista.repositorios.DoadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    DoadorRepository doadorRepository;

    @Autowired
    EnderecoService enderecoService;

    public Doador cadastrarDoador(Doador doador) {
        Doador doadorEncontrado = encontrarDoadorPorCpf(doador.getCpf());

        if (doadorEncontrado == null) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(
                    doador.getEndereco().getId(),
                    doador.getEndereco().getCep(),
                    doador.getEndereco().getLocalidade(),
                    doador.getEndereco().getBairro(),
                    doador.getEndereco().getUf()
            );
            enderecoService.cadastrarEndereco(enderecoDTO);
            doador.setEndereco(enderecoService.buscaEnderecoPorCep(doador.getEndereco().getCep()));
            return doadorRepository.save(doador);
        }
        return doadorEncontrado;
    }

    public Doador encontrarDoadorPorCpf(String cpf) {
        Optional<Doador> doador = doadorRepository.findByCpf(cpf);
        if (doador.isPresent()) {
            return doador.orElseThrow(() -> new RuntimeException("Doador não encontrado com o CPF: " + cpf));
        }
        return null;
    }

}
