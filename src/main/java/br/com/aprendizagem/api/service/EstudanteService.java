package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Estudante;
import br.com.aprendizagem.api.repository.EstudanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository){
        this.estudanteRepository = estudanteRepository;
    }

    @Transactional
    public ResponseEntity<List<Estudante>> getAllEstudantes() {
        List<Estudante> estudantes = estudanteRepository.findAll();
        if (estudantes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudantes);
    }
}
