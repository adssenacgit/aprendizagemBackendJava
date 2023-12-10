package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.repository.ParticipanteRepository;
import br.com.aprendizagem.api.response.ParticipanteResponse;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    @Transactional
    public ResponseEntity<List<Participante>> getAllParticipantes(){
        List<Participante> participantes = participanteRepository.findAll();
        if (participantes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participantes);
    }

    @Transactional
    public Participante getParticipanteById(Long participanteId) {
        return participanteRepository.findById(participanteId).orElse(null);
    }

    @Transactional
    public List<Participante> getParcipantesByEstudanteId(Long estudanteId){
        return participanteRepository.findByEstudanteId(estudanteId);
    }

    @Transactional
    public Long getParcipanteIdByGrupoIdByEstudanteId(Long grupoId, Long estudanteId){
        Participante participante = participanteRepository.findByGrupo_IdAndEstudante_Id(grupoId, estudanteId);
        if( participante != null ){
            return participante.getId();
        }
        return null;
    }

    @Transactional
    public ResponseEntity<List<ParticipanteResponse>> getParticipantesByGrupoId(Long grupoId) {
        List<Participante> participantes = participanteRepository.findByGrupo_Id(grupoId);
        if (participantes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ParticipanteResponse.of(participantes));
    }

    @Transactional
    public ResponseEntity<ParticipanteResponse> getParticipanteByEstudanteIdByGrupoId(Long estudanteId, Long grupoId) {
        Participante participante = participanteRepository.findByGrupo_IdAndEstudante_Id(grupoId,estudanteId);
        return ResponseEntity.ok(ParticipanteResponse.of(participante));
    }
}
