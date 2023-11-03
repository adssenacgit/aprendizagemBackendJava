package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.repository.EncontroRepository;
import br.com.aprendizagem.api.response.EncontroEstudanteResponse;
import br.com.aprendizagem.api.response.EncontroResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@AllArgsConstructor
@Service
public class EncontroService {

    private final EncontroRepository encontroRepository;
    private final SituacaoAprendizagemService situacaoAprendizagemService;
    private final ControleExecucaoService controleExecucaoService;
    @Transactional
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

    @Transactional
    public ResponseEntity<List<EncontroEstudanteResponse>> getEncontrosByGrupoIdByEstudanteId(Long grupoId, Long estudanteId) {
        List<Encontro> encontros = encontroRepository.findByGrupoId(grupoId).orElse(null);
        if(encontros == null){
            return ResponseEntity.notFound().build();
        }
        List<EncontroEstudanteResponse> encontroEstudanteResponses = new ArrayList<>();
        for(Encontro encontro: encontros){
            Integer presenca = controleExecucaoService.getPresencaByEncontroIdByEstudanteId(encontro.getId(), estudanteId);
            encontroEstudanteResponses.add(EncontroEstudanteResponse.of(encontro, presenca));
        }
        return ResponseEntity.ok(encontroEstudanteResponses);

    }

    @Transactional
    public Map<String, Integer> getNumeroObjetosAtividadesByEncontroId(Long encontroId){
        Integer totalAtividades = encontroRepository.countAtividadeByEncontroId(encontroId);
        Integer totalObjetos = encontroRepository.countObjetoAprendizagemByEncontroId(encontroId);
        Map<String, Integer> totalObjetosAtividades = new HashMap<>();
        totalObjetosAtividades.put("totalAtividades", totalAtividades);
        totalObjetosAtividades.put("totalObjetos", totalObjetos);
        return totalObjetosAtividades;
    }

    @Transactional
    public List<Encontro> getEncontrosListByGrupoId(Long grupoId){
        return encontroRepository.findByGrupoId(grupoId).orElse(null);
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
