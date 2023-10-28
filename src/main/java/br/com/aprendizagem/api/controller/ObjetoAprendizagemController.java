package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.service.ObjetoAprendizagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("objetoAprendizagem")
@AllArgsConstructor
public class ObjetoAprendizagemController {
    private final ObjetoAprendizagemService objetoAprendizagemService;

    @GetMapping
    public ResponseEntity<List<ObjetoAprendizagem>> getAllObjetosAprendizagem() {
        return objetoAprendizagemService.getAllObjetosAprendizagem();
    }
}
