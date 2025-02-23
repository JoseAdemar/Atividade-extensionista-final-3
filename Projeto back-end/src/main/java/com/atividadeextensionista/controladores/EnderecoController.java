package com.atividadeextensionista.controladores;

import com.atividadeextensionista.entidades.Endereco;
import com.atividadeextensionista.entidades.EnderecoDTO;
import com.atividadeextensionista.servicos.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private WebClient webClient;

    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO, UriComponentsBuilder uriBuilder) {
        EnderecoDTO dto = enderecoService.cadastrarEndereco(enderecoDTO);
        Endereco endereco = new Endereco(dto);
        var uri = uriBuilder.path("api/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/buscarEndereco")
    public Mono<EnderecoDTO> buscarEndereco(@RequestParam String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(EnderecoDTO.class)
                .flatMap(endereco -> Mono.just(endereco));
    }

    @GetMapping
    public Endereco getEnderecoByCep(String cep) {
        return enderecoService.buscaEnderecoPorCep(cep);
    }
}
