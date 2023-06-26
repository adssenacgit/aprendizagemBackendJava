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

import br.com.aprendizagem.api.entity.Noticia;
import br.com.aprendizagem.api.repository.NoticiaRepository;
import br.com.aprendizagem.api.request.PaginacaoRequest;
import br.com.aprendizagem.api.response.NoticiaResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticiaService {

	private NoticiaRepository noticiaRepository;
	
	@Transactional
	public ResponseEntity<NoticiaResponse> buscarNoticiaPorId(String id) {
		Optional<Encontro> noticiaOpt = noticiaRepository.findById(id);
		if (!noticiaOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(NoticiaResponse.of(noticiaOpt.get()));
	}

	@Transactional
	public ResponseEntity<List<NoticiaResponse>> listarnoticias() {
		List<Noticia> noticias = noticiaRepository.findAll();
		if (noticias.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(NoticiaResponse.of(noticias));
		//return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.OK);
	}	
	
	
//	@Transactional
//	public Page<NoticiaResponse> buscarNoticias(PaginacaoRequest paginacaoRequest) {
//		Pageable pageable = PageRequest.of(paginacaoRequest.getPagina(), paginacaoRequest.getItensPorPagina());
//		
//		Page<Noticia> noticias = noticiaRepository.findAllByOrderByNomeDesc(pageable);
//		return NoticiaResponse.of(usuarios);
//	}
	
	public ResponseEntity<List<Noticia>> cadastrarNoticia(List<Noticia> noticias) {
		for (Noticia noticia : noticias) {
			Noticia noticiaSalva = noticiaRepository.save(noticia);			
		}
		return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.CREATED);
	}

	public ResponseEntity<Noticia> atualizarNoticia(String id, Noticia noticia) {
		if (!isNoticiaPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		noticia.setId(id); 
		noticiaRepository.save(noticia);
		return new ResponseEntity<Noticia>(HttpStatus.OK);
	}
	
	public ResponseEntity<Noticia> excluirNoticia(String id) {
		if (!isNoticiaPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		noticiaRepository.deleteById(id);
		return new ResponseEntity<Noticia>(HttpStatus.OK);
	}
	
}
