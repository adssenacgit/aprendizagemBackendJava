package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.BadgeTipo;
import br.com.aprendizagem.api.repository.BadgeTipoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BadgeTipoService {
    private final BadgeTipoRepository badgeTipoRepository;
    public BadgeTipoService(BadgeTipoRepository badgeTipoRepository) {
        this.badgeTipoRepository = badgeTipoRepository;
    }

    @Transactional
    public List<BadgeTipo> getAllBadgeTipos() {
        return badgeTipoRepository.findAll();
    }

}
