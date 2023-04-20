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

import br.com.aprendizagem.api.entity.Usuario;
import br.com.aprendizagem.api.repository.UsuarioRepository;
import br.com.aprendizagem.api.request.PaginacaoRequest;
import br.com.aprendizagem.api.response.UsuarioResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public ResponseEntity<UsuarioResponse> buscarUsuarioPorId(String id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		if (!usuarioOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(UsuarioResponse.of(usuarioOpt.get()));
	}

	@Transactional
	public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(UsuarioResponse.of(usuarios));
		//return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}	
	
	
//	@Transactional
//	public Page<UsuarioResponse> buscarUsuarios(PaginacaoRequest paginacaoRequest) {
//		Pageable pageable = PageRequest.of(paginacaoRequest.getPagina(), paginacaoRequest.getItensPorPagina());
//		
//		Page<Usuario> usuarios = usuarioRepository.findAllByOrderByNomeDesc(pageable);
//		return UsuarioResponse.of(usuarios);
//	}
	
	public ResponseEntity<List<Usuario>> cadastrarUsuario(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			Usuario usuarioSalvo = usuarioRepository.save(usuario);			
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.CREATED);
	}

	public ResponseEntity<Usuario> atualizarUsuario(String id, Usuario usuario) {
		if (!isUsuarioPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(id); 
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	public ResponseEntity<Usuario> excluirUsuario(String id) {
		if (!isUsuarioPresent(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	private Boolean isUsuarioPresent (String id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		return usuarioOpt.isPresent();
	}
	
}
