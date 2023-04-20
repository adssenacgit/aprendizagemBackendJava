package br.com.aprendizagem.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.SenacCoinMovimentacao;

@Repository
public interface SenacCoinMovimentacaoRepository extends JpaRepository<SenacCoinMovimentacao, Long>{
	List<SenacCoinMovimentacao> findAllByUsuarioId(String usuarioId);
}
