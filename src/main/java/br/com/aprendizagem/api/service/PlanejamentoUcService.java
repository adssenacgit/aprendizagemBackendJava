package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.PlanejamentoUc;
import br.com.aprendizagem.api.repository.PlanejamentoUcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanejamentoUcService {
    private final PlanejamentoUcRepository planejamentoUcRepository;
}
