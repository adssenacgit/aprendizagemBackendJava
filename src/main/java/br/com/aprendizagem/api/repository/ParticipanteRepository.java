package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {


    List<Participante> findByEstudanteId(Long estudanteId);
}
