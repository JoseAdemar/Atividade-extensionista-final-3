package com.atividadeextensionista.repositorios;

import com.atividadeextensionista.entidades.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

    Optional<Doador> findByCpf(String cpf);
}
