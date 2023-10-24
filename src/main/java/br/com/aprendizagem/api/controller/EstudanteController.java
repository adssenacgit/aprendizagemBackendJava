package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Estudante;
import br.com.aprendizagem.api.service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estudante")
@AllArgsConstructor
public class EstudanteController {
    private final EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<Estudante>> getAllEstudantes() {
        return estudanteService.getAllEstudantes();
    }
}
