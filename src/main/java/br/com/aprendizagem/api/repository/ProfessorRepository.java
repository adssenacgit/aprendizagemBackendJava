package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
