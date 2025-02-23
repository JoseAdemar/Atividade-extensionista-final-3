package com.atividadeextensionista.controladores;

import com.atividadeextensionista.entidades.Doador;
import com.atividadeextensionista.servicos.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doadores")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @PostMapping
    public Doador cadastrarDoador(@RequestBody Doador doador) {
        return doadorService.cadastrarDoador(doador);
    }

    @GetMapping
    public Doador encontrarDoadorPorCpf(String cpf) {
        return doadorService.encontrarDoadorPorCpf(cpf);
    }
}
