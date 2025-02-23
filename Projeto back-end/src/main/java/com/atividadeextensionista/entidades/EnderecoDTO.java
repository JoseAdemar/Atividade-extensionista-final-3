package com.atividadeextensionista.entidades;

public record EnderecoDTO(Long id, String cep,
                          String localidade,
                          String bairro,
                          String uf) {
}
