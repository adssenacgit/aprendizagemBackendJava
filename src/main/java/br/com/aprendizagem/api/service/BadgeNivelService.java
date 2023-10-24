package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.BadgeNivel;
import br.com.aprendizagem.api.repository.BadgeNivelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeNivelService {
    private final BadgeNivelRepository badgeNivelRepository;

    public BadgeNivelService(BadgeNivelRepository badgeNivelRepository) {
        this.badgeNivelRepository = badgeNivelRepository;
    }

    public List<BadgeNivel> getAllBadgeNiveis() {
        return badgeNivelRepository.findAll();
    }
}
