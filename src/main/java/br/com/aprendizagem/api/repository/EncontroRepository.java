package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Encontro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncontroRepository extends JpaRepository<Encontro, Long> {
    List<Encontro> findByGrupoId(Long id);
}
