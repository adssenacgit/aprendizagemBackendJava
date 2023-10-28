package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.response.AcompanhamentoResponse;
import br.com.aprendizagem.api.service.AcompanhamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acompanhamento")
@AllArgsConstructor
public class AcompanhamentoController {
    private final AcompanhamentoService acompanhamentoService;

    @GetMapping
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponse() {
        return acompanhamentoService.getAcompanhamentosResponse();
    }

    @GetMapping("getAcompanhamentoById/{id}")
    public ResponseEntity<Acompanhamento> getAcompanhamentoById(@PathVariable Long id) {
        Acompanhamento acompanhamento = acompanhamentoService.getAcompanhamentoById(id);
        if (acompanhamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(acompanhamento);
    }

    @GetMapping("filtrarByGrupoIdByEstudanteId/{grupoId}/{estudanteId}")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteId(@PathVariable Long grupoId, @PathVariable Long estudanteId) {
        return acompanhamentoService.getAcompanhamentosResponseByGrupoIdByEstudanteId(grupoId, estudanteId);
    }

    @GetMapping("filtrarByEstudanteId/{estudanteId}/")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteId(@PathVariable Long estudanteId) {
        return acompanhamentoService.getAcompanhamentosResponseByEstudanteId(estudanteId);
    }

    @PostMapping
    public ResponseEntity<Acompanhamento> postAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        return ResponseEntity.ok(acompanhamentoService.postAcompanhamento(acompanhamento));
    }
}
