package br.com.aprendizagem.api.controller;


import br.com.aprendizagem.api.entity.BadgeTipo;
import br.com.aprendizagem.api.service.BadgeTipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("badge-tipo")
public class BadgeTipoController {
    private final BadgeTipoService badgeTipoService;

    public BadgeTipoController(BadgeTipoService badgeTipoService) {
        this.badgeTipoService = badgeTipoService;
    }

    @GetMapping
    public ResponseEntity<List<BadgeTipo>> getAllBadgeTipos(){
        List<BadgeTipo> badgeTipos = badgeTipoService.getAllBadgeTipos();
        if(badgeTipos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badgeTipos);

    }
}
