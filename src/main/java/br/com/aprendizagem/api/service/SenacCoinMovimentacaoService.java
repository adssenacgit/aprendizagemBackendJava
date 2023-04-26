package br.com.aprendizagem.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.SenacCoin;
import br.com.aprendizagem.api.entity.SenacCoinMovimentacao;
import br.com.aprendizagem.api.repository.SenacCoinMovimentacaoRepository;
import br.com.aprendizagem.api.repository.SenacCoinRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenacCoinMovimentacaoService {
	@Autowired
	private SenacCoinMovimentacaoRepository repo;
	@Autowired
	private SenacCoinRepository scRepo;
	
	@Transactional
	public SenacCoinMovimentacao buscarMovimentacaoPorId(Long id) {
		return repo.findById(id).get();
	}
	
	@Transactional
	public List<SenacCoinMovimentacao> buscarMovimentacoesPorUsuario(String usuarioId) {
		return repo.findAllByUsuarioId(usuarioId);
	}
	
	@Transactional
	public List<SenacCoinMovimentacao> buscarTodasMovimentacoes(){
		return repo.findAll();
	}
	
	@Transactional
	public SenacCoinMovimentacao cadastrarMovimentacao(SenacCoinMovimentacao senacCoinMovimentacao) {
		return repo.save(senacCoinMovimentacao);
	}
	
	@Transactional
	public SenacCoinMovimentacao atualizarMovimentacao(Long id, SenacCoinMovimentacao senacCoinMovimentacaoAlterado) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		return repo.save(senacCoinMovimentacaoAlterado);
	}
	
	@Transactional
	public String removerMovimentacao(Long id) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		repo.deleteById(id);
		return "Registro removido com sucesso.";
	}
	
	@Transactional
	public String adquirirSenacCoin(SenacCoinMovimentacao senacCoinMovimentacao, Long senacCoinId) {
		SenacCoin senacCoin = scRepo.findById(senacCoinId).get();
		if(senacCoin == null) {
			return null;
		}
		senacCoin.setSaldo(senacCoin.getSaldo() + senacCoinMovimentacao.getValor());
		
		senacCoinMovimentacao.setSenacCoin(senacCoin);
		
		repo.save(senacCoinMovimentacao);
		scRepo.save(senacCoin);
		return "Transação realizada com sucesso. Seu saldo agora é " + senacCoin.getSaldo() + ".";
	}
	
	@Transactional
	public String gastarSenacCoin(SenacCoinMovimentacao senacCoinMovimentacao, Long senacCoinId) {
		SenacCoin senacCoin = scRepo.findById(senacCoinId).get();
		if(senacCoin == null || senacCoin.getSaldo() < senacCoinMovimentacao.getValor()){
			return null;
		}
		senacCoin.setSaldo(senacCoin.getSaldo() - senacCoinMovimentacao.getValor());
		
		senacCoinMovimentacao.setSenacCoin(senacCoin);
		
		repo.save(senacCoinMovimentacao);
		scRepo.save(senacCoin);
		return "Transação realizada com sucesso. Seu saldo agora é " + senacCoin.getSaldo() + ".";
	}
}
