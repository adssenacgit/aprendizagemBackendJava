package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.response.EncontroEstudanteResponse;
import br.com.aprendizagem.api.response.ProgressoEstudanteResponse;
import br.com.aprendizagem.api.service.AcompanhamentoService;
import br.com.aprendizagem.api.service.EncontroService;
import br.com.aprendizagem.api.service.ParticipanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("progresso")
public class ProgressoController {
    private final EncontroService encontroService;
    private final ParticipanteService participanteService;
    private final AcompanhamentoService acompanhamentoService;

    @GetMapping("/{grupoId}/{estudanteId}")
    public ResponseEntity<ProgressoEstudanteResponse> getProgressoByGrupoIdByEstudanteId(@PathVariable Long grupoId, @PathVariable Long estudanteId){
        List<Encontro> encontros = encontroService.getEncontrosListByGrupoId(grupoId);
        Long participanteId = participanteService.getParcipanteIdByGrupoIdByEstudanteId(grupoId, estudanteId);
        if(participanteId != null){
            Integer totalObjetos = 0;
            Integer totalAtividades = 0;
            for (Encontro encontro : encontros) {
                Map<String, Integer> totalObjetosAtividades = encontroService.getNumeroObjetosAtividadesByEncontroId(encontro.getId());
                totalAtividades += totalObjetosAtividades.get("totalAtividades");
                totalObjetos += totalObjetosAtividades.get("totalObjetos");
            }
            Integer totalAcompanhados = acompanhamentoService.getTotalAcompanhamentosByParticipanteId(participanteId);

            return ResponseEntity.ok(ProgressoEstudanteResponse.of(totalObjetos, totalAtividades, totalAcompanhados));
        }
        return ResponseEntity.notFound().build();
    }


}
