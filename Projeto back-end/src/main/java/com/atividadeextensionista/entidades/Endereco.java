package com.atividadeextensionista.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;

    private String localidade;

    private String bairro;

    private String uf;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.id();
        this.cep = enderecoDTO.cep();
        this.localidade = enderecoDTO.localidade();
        this.bairro = enderecoDTO.bairro();
        this.uf = enderecoDTO.uf();
    }
}
