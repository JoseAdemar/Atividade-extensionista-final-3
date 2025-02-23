package com.atividadeextensionista.entidades;

import lombok.Data;

@Data
public class DoacaoProdutoDTO {
    private Long id;
    private Long doacaoId;
    private Long produtoId;
    private int quantidade;
}
