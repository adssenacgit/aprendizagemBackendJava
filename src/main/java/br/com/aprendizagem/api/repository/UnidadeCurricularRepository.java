package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.UnidadeCurricular;

@Repository
public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular, Long> {
    
}
