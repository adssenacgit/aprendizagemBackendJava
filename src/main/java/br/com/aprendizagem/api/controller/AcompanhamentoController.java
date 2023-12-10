package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.request.AcompanhamentoRequest;
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
        return ResponseEntity.ok().body(acompanhamento);
    }

    @GetMapping("filtrarByGrupoIdByEstudanteId/{grupoId}/{estudanteId}")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteId(@PathVariable Long grupoId, @PathVariable Long estudanteId) {
        return acompanhamentoService.getAcompanhamentosResponseByGrupoIdByEstudanteId(grupoId, estudanteId);
    }

    @GetMapping("filtrarByGrupoIdByEstudanteIdByAtividadeId/{grupoId}/{estudanteId}/{atividadeId}")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteIdByAtividadeId(@PathVariable Long grupoId, @PathVariable Long estudanteId, @PathVariable Long atividadeId) {
        return acompanhamentoService.getAcompanhamentosResponseByGrupoIdByEstudanteIdByAtividadeId(grupoId, estudanteId, atividadeId);
    }

    @GetMapping("filtrarByGrupoIdByEstudanteIdByObjetoId/{grupoId}/{estudanteId}/{objetoId}")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteIdByObjetoId(@PathVariable Long grupoId, @PathVariable Long estudanteId, @PathVariable Long objetoId) {
        return acompanhamentoService.getAcompanhamentosResponseByGrupoIdByEstudanteIdByObjetoId(grupoId, estudanteId, objetoId);
    }

    @GetMapping("filtrarByEstudanteId/{estudanteId}/")
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentoByGrupoIdByEstudanteId(@PathVariable Long estudanteId) {
        return acompanhamentoService.getAcompanhamentosResponseByEstudanteId(estudanteId);
    }

    @PostMapping
    public ResponseEntity<Acompanhamento> postAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        return ResponseEntity.ok(acompanhamentoService.postAcompanhamento(acompanhamento));
    }

    @PostMapping ("simple")
    public ResponseEntity<Acompanhamento> createAcompanhamento(@RequestBody AcompanhamentoRequest acompanhamentoRequest) {
        return acompanhamentoService.createAcompanhamento(acompanhamentoRequest);
    }
}
