package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.BadgeTipo;
import br.com.aprendizagem.api.repository.BadgeTipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class BadgeTipoService {
    private final BadgeTipoRepository badgeTipoRepository;
    @Transactional
    public List<BadgeTipo> getAllBadgeTipos() {
        return badgeTipoRepository.findAll();
    }

}
