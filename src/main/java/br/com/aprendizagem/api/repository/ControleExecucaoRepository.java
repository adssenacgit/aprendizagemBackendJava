package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.ControleExecucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControleExecucaoRepository extends JpaRepository<ControleExecucao, Long> {

    ControleExecucao findByEncontroIdAndParticipante_Estudante_Id(Long encontroId, Long estudanteId);
}
