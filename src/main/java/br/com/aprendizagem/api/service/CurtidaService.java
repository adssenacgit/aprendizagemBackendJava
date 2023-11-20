package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Curtida;
import br.com.aprendizagem.api.repository.CurtidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CurtidaService {

    private final CurtidaRepository curtidaRepository;

    @Transactional
    public List<Curtida> getAllCurtidas() {
        return curtidaRepository.findAll();
    }

    @Transactional
    public Curtida getCurtidaById(Integer id) {
        return curtidaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Curtida postCurtida(Curtida curtida) {
        return curtidaRepository.save(curtida);
    }

    @Transactional
    public void deleteByUsuarioId(String id) {
        curtidaRepository.deleteByUsuarioId(id);
    }
}
