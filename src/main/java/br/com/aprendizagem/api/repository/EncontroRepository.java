package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Encontro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EncontroRepository extends JpaRepository<Encontro, Long> {
    Optional<List<Encontro>> findByGrupoId(Long id);
}
