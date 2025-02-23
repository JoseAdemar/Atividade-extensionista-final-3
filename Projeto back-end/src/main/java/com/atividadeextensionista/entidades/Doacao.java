package com.atividadeextensionista.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Doacao {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doador doador;

    @OneToMany(mappedBy = "doacao")
    private List<DoacaoProduto> doacaoProdutos;

    private Boolean doacaoRecolhida = false;

    @CreationTimestamp
    private LocalDate localDate;

}
