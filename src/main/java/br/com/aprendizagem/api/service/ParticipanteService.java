package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

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
}
