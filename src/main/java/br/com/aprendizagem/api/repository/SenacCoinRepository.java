package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.SenacCoin;

@Repository
public interface SenacCoinRepository extends JpaRepository<SenacCoin, Long>{
	SenacCoin findByUsuarioId(String usuarioId);
}
