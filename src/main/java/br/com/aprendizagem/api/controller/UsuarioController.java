package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.entity.Usuario;
import br.com.aprendizagem.api.request.PaginacaoRequest;
import br.com.aprendizagem.api.response.UsuarioResponse;
import br.com.aprendizagem.api.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

	UsuarioService usuarioService;

	@GetMapping("/listar")
	@ApiOperation(value = "Listar todos os usuarios")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}	
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar usuario por id")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<UsuarioResponse> buscarUsuarioPorId(
			@ApiParam(name = "Id do usuario", required = true)
			@PathVariable String id) {
			
		return usuarioService.buscarUsuarioPorId(id);
	}
	
//	@GetMapping
//	public Page<UsuarioResponse> buscarUsuarios(@RequestParam Integer pagina, @RequestParam Integer itensPorPagina) {
//		
//		return usuarioService.buscarUsuarios(PaginacaoRequest.builder().pagina(pagina).itensPorPagina(itensPorPagina).build());
//	}
	
	@PostMapping
	public ResponseEntity<List<Usuario>> cadastrarUsuario(@RequestBody List<Usuario> usuarios) {
		return usuarioService.cadastrarUsuario(usuarios);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(id, usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> excluirUsuario(@PathVariable("id") String id) {
		return usuarioService.excluirUsuario(id);
	}
}
