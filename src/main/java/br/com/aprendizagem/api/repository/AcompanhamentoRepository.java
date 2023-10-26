package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
}
