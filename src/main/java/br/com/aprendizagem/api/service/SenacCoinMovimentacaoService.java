package br.com.aprendizagem.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.SenacCoin;
import br.com.aprendizagem.api.entity.SenacCoinMovimentacao;
import br.com.aprendizagem.api.repository.SenacCoinMovimentacaoRepository;
import br.com.aprendizagem.api.repository.SenacCoinRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenacCoinMovimentacaoService {
	private SenacCoinMovimentacaoRepository repo;
	private SenacCoinRepository scRepo;
	
	public SenacCoinMovimentacao buscarMovimentacaoPorId(Long id) {
		return repo.findById(id).get();
	}
	
	public List<SenacCoinMovimentacao> buscarMovimentacoesPorUsuario(String usuarioId) {
		return repo.findAllByUsuarioId(usuarioId);
	}
	
	public List<SenacCoinMovimentacao> buscarTodasMovimentacoes(){
		return repo.findAll();
	}
	
	public SenacCoinMovimentacao cadastrarMovimentacao(SenacCoinMovimentacao senacCoinMovimentacao) {
		return repo.save(senacCoinMovimentacao);
	}
	
	public SenacCoinMovimentacao atualizarMovimentacao(Long id, SenacCoinMovimentacao senacCoinMovimentacaoAlterado) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		return repo.save(senacCoinMovimentacaoAlterado);
	}
	
	public String removerMovimentacao(Long id) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		repo.deleteById(id);
		return "Registro removido com sucesso.";
	}
	
	public String realizarTransacao(SenacCoinMovimentacao senacCoinMovimentacao, boolean tipoTransacao) {
		SenacCoin senacCoin = scRepo.findById(senacCoinMovimentacao.getSenacCoinId()).get();
		if(senacCoin == null) {
			return null;
		}
		if(tipoTransacao == true) {
			senacCoin.setSaldo(senacCoin.getSaldo() + senacCoinMovimentacao.getValor());
		}else if(tipoTransacao == false) {
			if(senacCoin.getSaldo() < senacCoinMovimentacao.getValor()) {
				return null;
			}
			senacCoin.setSaldo(senacCoin.getSaldo() - senacCoinMovimentacao.getValor());
		}
		repo.save(senacCoinMovimentacao);
		scRepo.save(senacCoin);
		return "Transação realizada com sucesso. Seu saldo agora é " + senacCoin.getSaldo() + ".";
	}
}
