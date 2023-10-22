package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.GrauDificuldade;
import br.com.aprendizagem.api.service.GrauDificuldadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("grau-dificuldade")
public class GrauDificuldadeController {
    private final GrauDificuldadeService grauDificuldadeService;

    @GetMapping
    public ResponseEntity<List<GrauDificuldade>> getAllGrausDificuldade() {
        return grauDificuldadeService.getAllGrausDificuldade();
    }
}
