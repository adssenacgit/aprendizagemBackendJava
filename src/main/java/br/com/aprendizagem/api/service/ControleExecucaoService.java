package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ControleExecucao;
import br.com.aprendizagem.api.repository.ControleExecucaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ControleExecucaoService {
    private final ControleExecucaoRepository controleExecucaoRepository;

    public Integer getPresencaByEncontroIdByEstudanteId(Long encontroId, Long estudanteId){
        ControleExecucao controleExecucao = controleExecucaoRepository.findByEncontroIdAndParticipante_Estudante_Id(encontroId, estudanteId);
            if(controleExecucao == null) {
                return 0;
            }
           return controleExecucao.getStatus();
    }
}
