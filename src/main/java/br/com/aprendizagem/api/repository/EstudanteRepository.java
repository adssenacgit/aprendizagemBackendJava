package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
