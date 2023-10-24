package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.BadgeNivel;
import br.com.aprendizagem.api.service.BadgeNivelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("badge-nivel")
public class BadgeNivelController {
    private final BadgeNivelService badgeNivelService;

    public BadgeNivelController(BadgeNivelService badgeNivelService) {
        this.badgeNivelService = badgeNivelService;
    }

    @GetMapping
    public ResponseEntity<List<BadgeNivel>> getAllBadgeNiveis(){
        List<BadgeNivel> badgeNiveis = badgeNivelService.getAllBadgeNiveis();
        if(badgeNiveis.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badgeNiveis);
    }
}
