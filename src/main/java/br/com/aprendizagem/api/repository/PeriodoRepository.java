package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodoRepository extends JpaRepository<Periodo,Long> {
    Periodo findByStatus(int status);
}
