package br.com.aprendizagem.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.repository.EncontroRepository;
import br.com.aprendizagem.api.request.PaginacaoRequest;
import br.com.aprendizagem.api.response.EncontroResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EncontroService {

	private EncontroRepository encontroRepository;
	
	@Transactional
	public ResponseEntity<EncontroResponse> buscarEncontroPorId(String id) {
		Optional<Encontro> EncontroOpt = encontroRepository.findById(id);
		if (!encontroOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(EncontroResponse.of(EncontroOpt.get()));
	}

	@Transactional
	public ResponseEntity<List<EncontroResponse>> listarEncontros() {
		List<Encontro> encontros = encontroRepository.findAll();
		if (encontros.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(EncontroResponse.of(usuarios));
		//return new ResponseEntity<List<Encontro>>(encontros, HttpStatus.OK);
	}	
	
	
//	@Transactional
//	public Page<EncontroResponse> buscarEncontros(PaginacaoRequest paginacaoRequest) {
//		Pageable pageable = PageRequest.of(paginacaoRequest.getPagina(), paginacaoRequest.getItensPorPagina());
//		
//		Page<Encontro> encontros = encontroRepository.findAllByOrderByNomeDesc(pageable);
//		return EncontroResponse.of(usuarios);
//	}
	
	public ResponseEntity<List<Encontro>> cadastrarEncontro(List<Encontro> encontros) {
		for (Encontro encontro : encontros) {
			Encontro encontroSalvo = encontroRepository.save(encontro);			
		}
		return new ResponseEntity<List<Encontro>>(encontros, HttpStatus.CREATED);
	}

	public ResponseEntity<Encontro> atualizarEncontro(String id, Encontro Encontro) {
		if (!isEncontroPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		Encontro.setId(id); 
		encontroRepository.save(encontro);
		return new ResponseEntity<Encontro>(HttpStatus.OK);
	}
	
	public ResponseEntity<Encontro> excluirEncontro(String id) {
		if (!isEncontroPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		encontroRepository.deleteById(id);
		return new ResponseEntity<Encontro>(HttpStatus.OK);
	}

	private Boolean isEncontroPresent (String id) {
		Optional<Encontro> encontroOpt = encontroRepository.findById(id);
		return encontroOpt.isPresent();
	}
	
}
