package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.repository.EncontroRepository;
import br.com.aprendizagem.api.response.EncontroResponse;
import br.com.aprendizagem.api.response.EncontroSituacaoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EncontroService {

    public final EncontroRepository encontroRepository;
    private final SituacaoAprendizagemService situacaoAprendizagemService;
    public ResponseEntity<List<Encontro>> getAllEncontros() {
        List<Encontro> encontros = encontroRepository.findAll();
        if (encontros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontros);
    }

    @Transactional
    public ResponseEntity<List<EncontroResponse>> getEncontrosByGrupoId(Long id) {
        Optional<List<Encontro>> encontros = encontroRepository.findByGrupoId(id);
        if (encontros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EncontroResponse.of(encontros.get()));
    }

//    @Transactional
//    public ResponseEntity<List<EncontroSituacaoResponse>> getEncontrosSituacaoByGrupoId(Long grupoId) {
//        Optional<List<Encontro>> encontros = encontroRepository.findByGrupoId(grupoId);
//        if (encontros.isPresent()){
//            List<EncontroSituacaoResponse> encontrosSituacao = EncontroSituacaoResponse.of(encontros.get());
//            encontrosSituacao.forEach(
//                    encontro -> {
//                        encontro.setSituacoesAprendizagem(situacaoAprendizagemService.getSituacoesAprendizagemByEncontroId(encontro.getId()));
//                    }
//            );
//        }
//        else {
//            return ResponseEntity.noContent().build();
//        }
//
//    }
}
