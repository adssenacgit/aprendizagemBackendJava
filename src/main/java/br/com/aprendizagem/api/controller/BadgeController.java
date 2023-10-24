package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Badge;
import br.com.aprendizagem.api.service.BadgeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("badge")
public class BadgeController {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping
    public ResponseEntity<List<Badge>> getAllBadges(){
        List<Badge> badges = badgeService.getAllBadges();
        if(badges.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(badges);
    }

    @GetMapping("getBadgesByBadgeTipoId/{badgeTipoId}")
    public ResponseEntity<List<Badge>> getBadgesByBadgeTipoId(@PathVariable Integer badgeTipoId){
        List<Badge> badges = badgeService.getBadgesByBadgeTipoId(badgeTipoId);
        if(badges.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badges);
    }

    @GetMapping("getBadgesByBadgeNivelId/{badgeNivelId}")
    public ResponseEntity<List<Badge>> getBadgesByBadgeNivelId(@PathVariable Integer badgeNivelId){
        return badgeService.getBadgesByBadgeNivelId(badgeNivelId);
    }


}
