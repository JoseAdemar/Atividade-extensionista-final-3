package com.atividadeextensionista.entidades;

import java.time.LocalDate;
import java.util.List;

public record DoacaoDTO(
        Long id,
        Doador doador,
        Boolean doacaoRecolhida,
        LocalDate localDate,
        List<DoacaoProdutoDTO> doacaoProduto
) {
}
