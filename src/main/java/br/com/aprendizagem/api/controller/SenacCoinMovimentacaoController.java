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

import br.com.aprendizagem.api.entity.SenacCoinMovimentacao;
import br.com.aprendizagem.api.service.SenacCoinMovimentacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("senaccoinmovimentacao")
public class SenacCoinMovimentacaoController {
	@Autowired
	private SenacCoinMovimentacaoService mvService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar movimentacao por usuario.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Movimentacao encontrada."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<SenacCoinMovimentacao> buscarMovimentacaoPorId(@PathVariable Long id){
		SenacCoinMovimentacao mv = mvService.buscarMovimentacaoPorId(id);
		if(mv == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	@ApiOperation(value = "Buscar senac coin por usuario.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Movimentacao encontrada."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<List<SenacCoinMovimentacao>> buscarMovimentacaoPorUsuario(@PathVariable String usuarioId){
		List<SenacCoinMovimentacao> mvs = mvService.buscarMovimentacoesPorUsuario(usuarioId);
		if(mvs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mvs);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar senac coins.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Listagem realizada."),
			@ApiResponse(code = 204, message = "Nenhuma movimentacao encontrado."),
	})
	public ResponseEntity<List<SenacCoinMovimentacao>> buscarTodasMovimentacoes(){
		List<SenacCoinMovimentacao> mvLista = mvService.buscarTodasMovimentacoes();
		if(mvLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mvLista);
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastrar senac coin.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Cadastro realizado."),
	})
	public ResponseEntity<SenacCoinMovimentacao> cadastrarMovimentacao(@RequestBody SenacCoinMovimentacao senacCoinMovimentacao){
		SenacCoinMovimentacao mv = mvService.cadastrarMovimentacao(senacCoinMovimentacao);
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Buscar senac coin por usuario")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Movimentacao atualizada."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<SenacCoinMovimentacao> atualizarMovimentacao(@PathVariable Long id, @RequestBody SenacCoinMovimentacao senacCoinMovimentacaoAlterado){
		SenacCoinMovimentacao mv = mvService.atualizarMovimentacao(id, senacCoinMovimentacaoAlterado);
		if(mv == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Buscar senac coin por usuario")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Movimentacao removida."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<String> removerMovimentacao(@PathVariable Long id){
		String msg = mvService.removerMovimentacao(id);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@PostMapping("/adquirir/{senacCoinId}")
	@ApiOperation(value = "Buscar senac coin por usuario")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Transacao realizada."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<String> adquirirSenacCoin(@RequestBody SenacCoinMovimentacao senacCoinMovimentacao, @PathVariable Long senacCoinId){
		String msg = mvService.adquirirSenacCoin(senacCoinMovimentacao, senacCoinId);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@PostMapping("/gastar/{senacCoinId}")
	@ApiOperation(value = "Buscar senac coin por usuario")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Transacao realizada."),
			@ApiResponse(code = 404, message = "Não encontrado."),
	})
	public ResponseEntity<String> gastarSenacCoin(@RequestBody SenacCoinMovimentacao senacCoinMovimentacao, @PathVariable Long senacCoinId){
		String msg = mvService.gastarSenacCoin(senacCoinMovimentacao, senacCoinId);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
