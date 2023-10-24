package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {
    List<Badge> findByBadgeTipoId(Integer badgeTipoId);

    List<Badge> findByBadgeNivelId(Integer badgeNivelId);


}
