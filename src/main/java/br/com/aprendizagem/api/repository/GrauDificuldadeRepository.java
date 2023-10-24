package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.GrauDificuldade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrauDificuldadeRepository extends JpaRepository<GrauDificuldade, Integer> {
}
