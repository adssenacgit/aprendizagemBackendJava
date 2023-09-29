package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Periodo;
import br.com.aprendizagem.api.repository.PeriodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PeriodoService {
    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    @Transactional
    public List<Periodo> getAllPeriodos(){
        return periodoRepository.findAll();
    }

    @Transactional
    public Periodo getPeriodoAtivo() {
        return periodoRepository.findByStatus(1);
    }
}
