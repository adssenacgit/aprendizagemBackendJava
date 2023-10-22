package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
//    @Query("SELECT g FROM Grupo g JOIN g.estudantes s WHERE s.id = :estudanteId")
    @Query("SELECT p.grupo FROM Participante p WHERE p.estudante.id = :estudanteId")
    List<Grupo> findGruposByEstudanteId(@Param("estudanteId") Long estudanteId);

//    @Query("SELECT g FROM Grupo g JOIN g.estudantes s WHERE s.id = :estudanteId AND g.periodo.status = 1")
//    List<Grupo> getGruposByPeriodoAtivoEstudanteId(@Param("estudanteId") Long estudanteId);

    List<Grupo> getGruposByProfessorId(Long professorId);
}
