package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Badge;
import br.com.aprendizagem.api.repository.BadgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BadgeService {
    private final BadgeRepository badgeRepository;

    @Transactional
    public List<Badge> getAllBadges() {
        List<Badge> badges = badgeRepository.findAll();
        return filterActive(badges);
    }

    @Transactional
    public List<Badge> getBadgesByBadgeTipoId(Integer badgeTipoId) {
        List<Badge> badges = badgeRepository.findByBadgeTipoId(badgeTipoId);
        return filterActive(badges);
    }

    @Transactional
    public ResponseEntity<List<Badge>> getBadgesByBadgeNivelId(Integer badgeNivelId) {
        List<Badge> badges = badgeRepository.findByBadgeNivelId(badgeNivelId);
        if(badges.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badges);
    }

    public List<Badge> filterActive(List<Badge> badges) {
        return badges.stream().filter(b -> b.getStatus() == 1).collect(Collectors.toList());
    }
}
