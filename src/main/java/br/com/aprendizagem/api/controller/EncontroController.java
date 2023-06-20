package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.response.EncontroResponse;
import br.com.aprendizagem.api.service.EncontroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/encontro")
public class EncontroController {

	EncontroService encontroService;

	@GetMapping("/listar")
	@ApiOperation(value = "Listar todos os encontros")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<List<EncontroResponse>> listarEncontros() {
		return encontroService.listarEncontros();
	}	
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar encontro por id")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<EncontroResponse> buscarEncontroPorId(
			@ApiParam(name = "Id do encontro", required = true)
			@PathVariable String id) {
			
		return encontroService.buscarEncontroPorId(id);
	}
	
//	@GetMapping
//	public Page<EncontroResponse> buscarEncontros(@RequestParam Integer pagina, @RequestParam Integer itensPorPagina) {
//		
//		return encontroService.buscarEncontros(PaginacaoRequest.builder().pagina(pagina).itensPorPagina(itensPorPagina).build());
//	}
	
	@PostMapping
	public ResponseEntity<List<Encontro>> cadastrarEncontro(@RequestBody List<Encontro> encontros) {
		return encontroService.cadastrarUsuario(encontros);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Encontro> atualizarEncontro(@PathVariable("id") String id, @RequestBody Encontro encontro) {
		return encontroService.atualizarEncontro(id, encontro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Encontro> excluirUsuario(@PathVariable("id") String id) {
		return encontroService.excluirEncontro(id);
	}
}
