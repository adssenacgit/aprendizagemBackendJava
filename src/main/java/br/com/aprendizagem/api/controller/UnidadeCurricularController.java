package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import br.com.aprendizagem.api.response.UnidadeCurricularResponse;
import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.service.UnidadeCurricularService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/unidadeCurricular")
public class UnidadeCurricularController {

	@Autowired
	private UnidadeCurricularService unidadeCurricularService;

	@GetMapping("/{modulo}")
	@ApiOperation(value = "Buscar unidade curricular por módulo")
	@ApiResponses({
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Proibido."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<UnidadeCurricularResponse> listarUnidadeCurricularPorModulo(@PathVariable Long modulo) {
		return unidadeCurricularService.listarUnidadeCurricularPorModulo(modulo);
	}

	@GetMapping("/listar")
	@ApiOperation(value = "Listar todas as unidades curriculares")
	@ApiResponses({
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Proibido."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<List<UnidadeCurricularResponse>> listarUnidadesCurriculares() {
		return unidadeCurricularService.listarUnidadesCurriculares();
	}

}
