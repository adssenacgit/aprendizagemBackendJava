package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {


    @Query("SELECT c FROM Curtida c WHERE c.chapterAssuntoComentario.id = :comentarioId")
    List<Curtida> getCurtidasByComentarioId(Long comentarioId);

}
