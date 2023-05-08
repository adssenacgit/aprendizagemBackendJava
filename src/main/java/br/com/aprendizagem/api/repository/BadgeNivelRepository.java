package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.BadgeNivel;

@Repository
public interface BadgeNivelRepository extends JpaRepository<BadgeNivel, Integer> {
	

}
