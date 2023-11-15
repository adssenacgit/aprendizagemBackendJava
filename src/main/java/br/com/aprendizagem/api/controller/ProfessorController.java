package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Professor;
import br.com.aprendizagem.api.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("professor")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessoresAtivos() {
        List<Professor> professores = professorService.getProfessoresAtivos();
        if (professores.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("filtrar-professor-por-usuario-id/{usuarioId}")
    public ResponseEntity<Professor> getProfessorByUsuarioId(@PathVariable String usuarioId){
        return professorService.getProfessorByUsuarioId(usuarioId);
    }
}
