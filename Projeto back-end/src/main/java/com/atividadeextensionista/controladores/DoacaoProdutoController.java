package com.atividadeextensionista.controladores;

import com.atividadeextensionista.entidades.DoacaoConsultaDTO;
import com.atividadeextensionista.repositorios.DoacaoProdutoRepository;
import com.atividadeextensionista.servicos.DoacaoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doacoes/recebidas")
public class DoacaoProdutoController {

    @Autowired
    private DoacaoProdutoService doacaoProdutoService;

    @GetMapping
    public ResponseEntity<List<DoacaoConsultaDTO>> resumoDoacoesRecebidas() {
        List<DoacaoConsultaDTO> dto = doacaoProdutoService.obterResumoDoacoes();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarStatusDoacao(@PathVariable Long id) {
        doacaoProdutoService.updateDoacaoRecolhidaStatus(id);
        return ResponseEntity.ok().build();
    }

}
