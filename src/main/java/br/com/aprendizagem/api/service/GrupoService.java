package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Grupo;
import br.com.aprendizagem.api.repository.GrupoRepository;
import br.com.aprendizagem.api.repository.ParticipanteRepository;
import br.com.aprendizagem.api.response.GrupoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository, ParticipanteRepository participanteRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Transactional
    public ResponseEntity<List<GrupoResponse>> getAllGrupos(){
        List<Grupo> grupos = grupoRepository.findAll();
        if (grupos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GrupoResponse.of(grupos));
    }

    @Transactional
    public ResponseEntity<GrupoResponse> getGrupoById(Long grupo_id) {
        Optional<Grupo> grupoOpt = grupoRepository.findById(grupo_id);
        if(grupoOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GrupoResponse.of(grupoOpt.get()));
    }

    @Transactional
    public List<Grupo> getGruposByEstudanteId(Long estudante_id) {
        return grupoRepository.getGruposByEstudanteId(estudante_id);
    }

    @Transactional
    public List<Grupo> getGruposByPeriodoAtivoByEstudanteId(Long estudanteId) {
        return grupoRepository.getGruposByPeriodoAtivoEstudanteId(estudanteId);
    }

    @Transactional
    public List<Grupo> getGruposByPeriodoAtivoByProfessorId(Long professorId) {
        return filterActive(grupoRepository.getGruposByProfessorId(professorId));
    }

    public List<Grupo> filterActive(List<Grupo> grupos) {
        return grupos.stream().filter(g -> g.getPeriodo().getStatus() == 1).collect(Collectors.toList());
    }
}


