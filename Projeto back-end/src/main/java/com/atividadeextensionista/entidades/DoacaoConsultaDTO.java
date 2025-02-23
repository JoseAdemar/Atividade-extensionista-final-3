package com.atividadeextensionista.entidades;

import java.math.BigDecimal;

public record DoacaoConsultaDTO(
        Long doacaoId,
        BigDecimal totalItens,
        String produtos,
        Boolean doacaoRecolhida,
        String nomeDoador,
        String emailDoador,
        String telefoneDoador,
        String cep,
        String uf,
        String localidade
        ) {
}
