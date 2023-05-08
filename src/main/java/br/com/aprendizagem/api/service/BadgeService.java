package br.com.aprendizagem.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Badge;
import br.com.aprendizagem.api.entity.BadgeNivel;
import br.com.aprendizagem.api.repository.BadgeNivelRepository;
import br.com.aprendizagem.api.repository.BadgeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class BadgeService {
	@Autowired
	private BadgeRepository repo;
	
	@Autowired
	private BadgeNivelRepository nrepo;
	
	public List<Badge> buscarBadgeId(Integer badgeId){
		return repo.findAllByBadgeId(badgeId);
	}
	
	public List<Badge> buscarBadgeNivelId(Integer badgeNivelId){
		BadgeNivel badgeNivel = nrepo.findById(badgeNivelId).get();
		return repo.findAllByBadgeNivel(badgeNivel);
	}
	
	
}

