package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
