package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    @Query("SELECT r from Recurso r WHERE r.status = 1")
    List<Recurso> getActiveRecursos();
}
