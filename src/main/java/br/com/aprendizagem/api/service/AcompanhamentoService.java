package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.repository.AcompanhamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AcompanhamentoService {

    private final AcompanhamentoRepository acompanhamentoRepository;


    public List<Acompanhamento> getAcompanhamentos() {
        List<Acompanhamento> list = new ArrayList<>();
        for (Acompanhamento acompanhamento : acompanhamentoRepository.findAll()) {
            if (acompanhamento.getStatus() == 1) {
                list.add(acompanhamento);
            }
        }
        return list;
    }

    public Acompanhamento getAcompanhamentoById(Long id) {
        Acompanhamento acompanhamento = acompanhamentoRepository.findById(id).orElse(null);
        if (acompanhamento != null && acompanhamento.getStatus() == 1) {
            return acompanhamento;
        }
        return null;
    }

    public Acompanhamento postAcompanhamento(Acompanhamento acompanhamento) {
        return acompanhamentoRepository.save(acompanhamento);
    }

}
