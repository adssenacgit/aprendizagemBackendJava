package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import br.com.aprendizagem.api.entity.SituacaoEncontro;
import br.com.aprendizagem.api.repository.SituacaoEncontroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SituacaoEncontroService {
    private final SituacaoEncontroRepository situacaoEncontroRepository;

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagem>> getSituacoesAprendizagemByEncontroId(Long encontroId) {
        Optional<List<SituacaoEncontro>> optSituacoesEncontro = situacaoEncontroRepository.findByEncontroId(encontroId);

        if (optSituacoesEncontro.isPresent()) {
            List<SituacaoAprendizagem> situacoesAprendizagem = new ArrayList<>();
            List<SituacaoEncontro> situacoesEncontro = optSituacoesEncontro.get();
            situacoesEncontro.forEach(situacaoEncontro -> situacoesAprendizagem.add(situacaoEncontro.getSituacaoAprendizagem()));
            return ResponseEntity.ok(situacoesAprendizagem);
        }
        return ResponseEntity.notFound().build();
    }

}
