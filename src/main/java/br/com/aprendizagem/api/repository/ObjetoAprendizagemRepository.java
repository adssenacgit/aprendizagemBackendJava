package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetoAprendizagemRepository extends JpaRepository<ObjetoAprendizagem, Long> {

    @Query("SELECT DISTINCT o FROM ObjetoAprendizagem o LEFT JOIN FETCH o.recursos")
    List<ObjetoAprendizagem> findAllWithRecursos();

    @Query("SELECT o FROM ObjetoAprendizagem o LEFT JOIN FETCH o.recursos WHERE o.id = :objetoId")
    ObjetoAprendizagem findByIdWithRecursos(Long objetoId);
}
