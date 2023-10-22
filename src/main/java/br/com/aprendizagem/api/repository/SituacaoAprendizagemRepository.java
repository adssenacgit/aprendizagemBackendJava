package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoAprendizagemRepository extends JpaRepository<SituacaoAprendizagem, Long> {
}
