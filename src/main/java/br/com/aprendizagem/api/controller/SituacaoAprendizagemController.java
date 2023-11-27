package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import br.com.aprendizagem.api.request.SituacaoAprendizagemRequest;
import br.com.aprendizagem.api.response.SituacaoAprendizagemResponse;
import br.com.aprendizagem.api.service.SituacaoAprendizagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<SituacaoAprendizagemResponse> getSituacaoAprendizagemById(@PathVariable Long id) {
        return situacaoAprendizagemService.getSituacaoAprendizagemById(id);
    }

    @GetMapping("filtrarSituacoesAprendizagemPorEncontroId/{encontroId}")
    public ResponseEntity<List<SituacaoAprendizagem>> getSituacoesAprendizagemByEncontroId(@PathVariable Long encontroId) {
        return situacaoAprendizagemService.getSituacoesAprendizagemByEncontroId(encontroId);
    }

    @GetMapping("filtrarSituacoesAprendizagemPorPlanejamentoUcId/{planejamentoUcId}")
    public ResponseEntity<List<SituacaoAprendizagemResponse>> getSituacoesAprendizagemByPlanejamentoUcId(@PathVariable Long planejamentoUcId) {
        return situacaoAprendizagemService.getSituacoesAprendizagemByPlanejamentoUcId(planejamentoUcId);
    }

    @PostMapping
    public ResponseEntity<SituacaoAprendizagem> createSituacaoAprendizagem(@RequestBody SituacaoAprendizagemRequest situacaoRequest) {
        return situacaoAprendizagemService.createSituacaoAprendizagem(situacaoRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SituacaoAprendizagem> updateSituacaoAprendizagem(@PathVariable Long id,@RequestBody SituacaoAprendizagem situacaoAprendizagem) {
        return situacaoAprendizagemService.updateSituacaoAprendizagem(id, situacaoAprendizagem);
    }
}

