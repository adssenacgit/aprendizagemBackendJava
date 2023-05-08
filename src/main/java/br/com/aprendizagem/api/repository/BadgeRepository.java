package br.com.aprendizagem.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.Badge;
import br.com.aprendizagem.api.entity.BadgeNivel;


@Repository
public interface  BadgeRepository extends JpaRepository< Badge, Integer> {
	List<Badge> findAllByBadgeId(Integer badgeId);
	List<Badge> findAllByBadgeNivel(BadgeNivel badgeNivelId);


}


