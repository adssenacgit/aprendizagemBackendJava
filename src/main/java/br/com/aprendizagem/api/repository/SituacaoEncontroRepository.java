package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.SituacaoEncontro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SituacaoEncontroRepository extends JpaRepository<SituacaoEncontro, Integer> {
    public Optional<List<SituacaoEncontro>> findByEncontroId(Long encontroId);
}
