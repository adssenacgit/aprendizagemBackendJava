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

import br.com.aprendizagem.api.entity.Noticia;
import br.com.aprendizagem.api.response.NoticiaResponse;
import br.com.aprendizagem.api.service.NoticiaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/noticia")
public class NoticiaController {

	NoticiaService noticiaService;

	@GetMapping("/listar")
	@ApiOperation(value = "Listar todos as noticias")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<List<NoticiaResponse>> listarNoticias() {
		return noticiaService.listarNoticias();
	}	
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar noticia por id")
	@ApiResponses(
			{
				@ApiResponse(code = 401, message = "Acesso não autorizado."),
				@ApiResponse(code = 403, message = "Proibido."),
				@ApiResponse(code = 404, message = "Não encontrado."),
			})
	public ResponseEntity<NoticiaResponse> buscarNoticiaPorId(
			@ApiParam(name = "Id da noticia", required = true)
			@PathVariable String id) {
			
		return noticiaService.buscarNoticiaPorId(id);
	}
	
//	@GetMapping
//	public Page<NoticiaResponse> buscarNoticias(@RequestParam Integer pagina, @RequestParam Integer itensPorPagina) {
//		
//		return noticiaService.buscarNoticias(PaginacaoRequest.builder().pagina(pagina).itensPorPagina(itensPorPagina).build());
//	}
	
	@PostMapping
	public ResponseEntity<List<Noticia>> cadastrarNoticia(@RequestBody List<Noticia> noticias) {
		return noticiaService.cadastrarNoticia(noticia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<noticia> atualizarNoticia(@PathVariable("id") String id, @RequestBody Noticia noticia) {
		return noticiaService.atualizarNoticia(id, noticia);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Noticia> excluirNoticia(@PathVariable("id") String id) {
		return noticiaService.excluirNotcia(id);
	}
}
