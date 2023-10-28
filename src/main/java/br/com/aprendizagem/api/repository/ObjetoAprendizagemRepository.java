package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetoAprendizagemRepository extends JpaRepository<ObjetoAprendizagem, Long> {
}
