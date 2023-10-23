package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.repository.AcompanhamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AcompanhamentoService {

    private final AcompanhamentoRepository acompanhamentoRepository;


    public List<Acompanhamento> getAllAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }

    public Acompanhamento getAcompanhamentoById(Long id) {
        return acompanhamentoRepository.findById(id).orElse(null);
    }

    public Acompanhamento postAcompanhamento(Acompanhamento acompanhamento) {
        return acompanhamentoRepository.save(acompanhamento);
    }

}
