package br.com.aprendizagem.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.SenacCoin;
import br.com.aprendizagem.api.repository.SenacCoinRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SenacCoinService {
	private SenacCoinRepository repo;
	
	@Transactional
	public SenacCoin buscarSenacCoinPorId(Long id) {
		return repo.findById(id).get();
	}
	
	@Transactional
	public SenacCoin buscarSenacCoinPorUsuario(String usuarioId) {
		return repo.findByUsuarioId(usuarioId);
	}
	
	@Transactional
	public List<SenacCoin> buscarTodosSenacCoin(){
		return repo.findAll();
	}
	
	@Transactional
	public SenacCoin cadastrarSenacCoin(SenacCoin senacCoin) {
		return repo.save(senacCoin);
	}
	
	@Transactional
	public SenacCoin atualizarSenacCoin(Long id, SenacCoin senacCoinAlterado) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		return repo.save(senacCoinAlterado);
	}
	
	@Transactional
	public String removerSenacCoin(Long id) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		repo.deleteById(id);
		return "Registro removido com sucesso.";
	}
}

