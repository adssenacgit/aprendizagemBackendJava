package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.entity.SenacCoin;
import br.com.aprendizagem.api.service.SenacCoinService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "senaccoin", produces = APPLICATION_JSON_VALUE)
public class SenacCoinController {
	@Autowired
	private SenacCoinService scService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar senac coin por ID.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Senac coin encontrado."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<SenacCoin> buscarSenacCoinPorId(@PathVariable Long id){
		SenacCoin sc = scService.buscarSenacCoinPorId(id);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	@ApiOperation(value = "Buscar senac coin por usuario.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Senac coin encontrado."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<SenacCoin> buscarSenacCoinPorUsuario(@PathVariable String usuarioId){
		SenacCoin sc = scService.buscarSenacCoinPorUsuario(usuarioId);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar senac coins.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Listagem realizada."),
			@ApiResponse(code = 204, message = "Nenhum senac coin encontrado."),
	})
	public ResponseEntity<List<SenacCoin>> buscarTodosSenacCoin(){
		List<SenacCoin> scLista = scService.buscarTodosSenacCoin();
		if(scLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(scLista);
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastrar senac coin.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Cadastro realizado."),
	})
	public ResponseEntity<SenacCoin> cadastrarSenacCoin(@RequestBody SenacCoin senacCoin){
		SenacCoin sc = scService.cadastrarSenacCoin(senacCoin);
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar senac coin.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Senac coin atualizado."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<SenacCoin> atualizarSenacCoin(@PathVariable Long id, @RequestBody SenacCoin senacCoinAlterado){
		SenacCoin sc = scService.atualizarSenacCoin(id, senacCoinAlterado);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remover senac coin.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Senac coin removido."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<String> removerSenacCoin(@PathVariable Long id){
		String msg = scService.removerSenacCoin(id);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
