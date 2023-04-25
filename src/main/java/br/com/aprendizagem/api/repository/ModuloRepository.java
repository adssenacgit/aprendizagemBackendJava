package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    
}
