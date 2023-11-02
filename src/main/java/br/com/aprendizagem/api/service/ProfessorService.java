package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Professor;
import br.com.aprendizagem.api.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Transactional
    public List<Professor> getProfessoresAtivos(){
        return professorRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Professor> getProfessorByUsuarioId(String usuarioId) {
        Professor professor = professorRepository.findByUsuarioId(usuarioId);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }
}
