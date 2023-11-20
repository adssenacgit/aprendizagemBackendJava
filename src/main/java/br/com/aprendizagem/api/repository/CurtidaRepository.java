package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {

    @Modifying
    @Query("DELETE FROM Curtida WHERE usuario.id = :usuarioId")
    void deleteByUsuarioId(String usuarioId);

}
