package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.repository.ParticipanteRepository;
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
}
