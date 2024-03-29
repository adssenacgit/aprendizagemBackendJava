package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {

    @Query("SELECT a from Acompanhamento a WHERE a.status != -1")
    List<Acompanhamento> getActiveAcompanhamentos();

    List<Acompanhamento> findByParticipante_Grupo_IdAndParticipante_Estudante_Id(Long grupoId, Long estudanteId);

    List<Acompanhamento> findByParticipante_Estudante_Id(Long estudanteId);

    List<Acompanhamento> findByAtividade_IdAndParticipante_Estudante_Id(Long atividadeId, Long estudanteId);

    List<Acompanhamento> findByObjetoAprendizagem_IdAndParticipante_Estudante_Id(Long objetoId, Long estudanteId);

    List<Acompanhamento> findByParticipante_Grupo_IdAndParticipante_Estudante_IdAndAtividade_Id(Long grupoId, Long estudanteId, Long atividadeId);

    List<Acompanhamento> findByParticipante_Grupo_IdAndParticipante_Estudante_IdAndObjetoAprendizagem_Id(Long grupoId, Long estudanteId, Long objetoId);
}
