package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Encontro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EncontroRepository extends JpaRepository<Encontro, Long> {
    Optional<List<Encontro>> findByGrupoId(Long id);

    @Query("SELECT COUNT (sao) FROM Encontro e " +
            "JOIN e.situacoesAprendizagem sa " +
            "JOIN sa.objetosAprendizagem sao " +
            "WHERE e.id = :encontroId")
    Integer countObjetoAprendizagemByEncontroId(@Param("encontroId") Long encontroId);

    @Query("SELECT COUNT (a) FROM Encontro e " +
            "JOIN e.situacoesAprendizagem sa " +
            "JOIN sa.atividades a " +
            "WHERE e.id = :encontroId")
    Integer countAtividadeByEncontroId(@Param("encontroId") Long encontroId);
}
