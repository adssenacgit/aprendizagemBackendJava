package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.BadgeNivel;
import br.com.aprendizagem.api.repository.BadgeNivelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class BadgeNivelService {
    private final BadgeNivelRepository badgeNivelRepository;

    @Transactional
    public List<BadgeNivel> getAllBadgeNiveis() {
        return badgeNivelRepository.findAll();
    }
}
