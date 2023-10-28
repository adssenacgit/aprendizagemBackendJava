package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Atividade;
import br.com.aprendizagem.api.service.AtividadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("atividade")
@AllArgsConstructor
public class AtividadeController {
    private final AtividadeService atividadeService;
    @GetMapping
    public ResponseEntity<List<Atividade>> getAllAtividades(){
        return atividadeService.getActiveAtividades();
    }

}
