package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.response.ParticipanteResponse;
import br.com.aprendizagem.api.service.ParticipanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "participante")
public class ParticipanteController {
    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public ResponseEntity<List<Participante>> getAllParticipantes() {
        return participanteService.getAllParticipantes();
    }

    @GetMapping("filtrar-por-estudante-id/{estudanteId}")
    public ResponseEntity<List<ParticipanteResponse>> getParticipantesByEstudanteId(@PathVariable Long estudanteId){
        List<Participante> participantes = participanteService.getParcipantesByEstudanteId(estudanteId);
        if (participantes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ParticipanteResponse.of(participantes));
    }

    @GetMapping("filtrar-participantes-por-grupo-id/{grupoId}")
    public ResponseEntity<List<ParticipanteResponse>> getParticipantesByGrupoId(@PathVariable Long grupoId) {
        return participanteService.getParticipantesByGrupoId(grupoId);
    }

    @GetMapping("filtrar-participante-por-estudante-id-por-grupo-id/{estudanteId}/{grupoId}")
    public ResponseEntity<ParticipanteResponse> getParticipanteByEstudanteIdByGrupoId(@PathVariable Long estudanteId, @PathVariable Long grupoId) {
        return participanteService.getParticipanteByEstudanteIdByGrupoId(estudanteId, grupoId);
    }
}


