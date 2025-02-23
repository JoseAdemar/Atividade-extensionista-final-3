package com.atividadeextensionista.controladores;

import com.atividadeextensionista.entidades.Doacao;
import com.atividadeextensionista.entidades.DoacaoDTO;
import com.atividadeextensionista.servicos.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping
    public void guardarDoacao(@RequestBody DoacaoDTO doacaoDTO){
        doacaoService.registrarDoacao(doacaoDTO);
    }
}
