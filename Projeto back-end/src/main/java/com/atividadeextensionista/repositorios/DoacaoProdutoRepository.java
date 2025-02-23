package com.atividadeextensionista.repositorios;

import com.atividadeextensionista.entidades.DoacaoConsultaDTO;
import com.atividadeextensionista.entidades.DoacaoProduto;
import com.atividadeextensionista.entidades.DoacaoProdutoDTO;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoProdutoRepository extends JpaRepository<DoacaoProduto, Long> {

    @Query(value = "SELECT dp.doacao_id AS doacaoId, " +
            "SUM(dp.quantidade) AS totalItens, " +
            "GROUP_CONCAT(p.nome SEPARATOR ', ') AS produtos, " +
            "d.doacao_recolhida AS doacaoRecolhida, " +
            "c.nome AS nomeDoador, " +
            "c.email AS emailDoador, " +
            "c.telefone AS telefoneDoador, " +
            "e.cep AS cepEndereco, " +
            "e.uf AS ufEndereco, " +
            "e.localidade AS cidade " +
            "FROM doacao_produto dp " +
            "INNER JOIN doacao d ON dp.doacao_id = d.id " +
            "INNER JOIN doador c ON dp.doacao_id = c.id " +
            "INNER JOIN endereco e ON c.endereco_id = e.id " +
            "INNER JOIN produto p ON dp.produto_id = p.id " +
            "WHERE d.doacao_recolhida = false " +
            "GROUP BY dp.doacao_id, d.doacao_recolhida " +
            "ORDER BY dp.doacao_id",
            nativeQuery = true)
    List<Tuple> buscarResumoDoacoes();


    @Modifying
    @Transactional
    @Query("UPDATE Doacao d SET d.doacaoRecolhida = true WHERE d.id = :id")
    void updateDoacaoRecolhida(@Param("id") Long id);

}
