package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.AtividadeTipo;
import br.com.aprendizagem.api.service.AtividadeTipoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("atividadeTipo")
public class AtividadeTipoController {
    private final AtividadeTipoService atividadeTipoService;

    @GetMapping
    public ResponseEntity<List<AtividadeTipo>> getAllAtividadeTipo() {
        return atividadeTipoService.getAllAtividadeTipo();
    }
}
