package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SituacaoAprendizagemRepository extends JpaRepository<SituacaoAprendizagem, Long> {

    List<SituacaoAprendizagem> findByPlanejamentoUc_Id (Long planejamentoUcId);
}
