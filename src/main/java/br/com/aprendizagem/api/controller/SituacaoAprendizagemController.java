package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import br.com.aprendizagem.api.response.SituacaoAprendizagemResponse;
import br.com.aprendizagem.api.service.SituacaoAprendizagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "situacao-aprendizagem")
@AllArgsConstructor
public class SituacaoAprendizagemController {
    private final SituacaoAprendizagemService situacaoAprendizagemService;

    @GetMapping
    public ResponseEntity<List<SituacaoAprendizagemResponse>> getAllSituacoesAprendizagem() {
        return situacaoAprendizagemService.getAllSituacoesAprendizagem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoAprendizagem> getSituacaoAprendizagemById(@PathVariable Long id) {
        return situacaoAprendizagemService.getSituacaoAprendizagemById(id);
    }

}

