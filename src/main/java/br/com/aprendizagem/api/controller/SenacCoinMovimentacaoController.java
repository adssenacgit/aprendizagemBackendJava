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
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("senaccoinmovimentacao")
public class SenacCoinMovimentacaoController {
	@Autowired
	private SenacCoinMovimentacaoService mvService;
	
	@GetMapping("/{id}")
	public ResponseEntity<SenacCoinMovimentacao> buscarMovimentacaoPorId(@PathVariable Long id){
		SenacCoinMovimentacao mv = mvService.buscarMovimentacaoPorId(id);
		if(mv == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<SenacCoinMovimentacao>> buscarMovimentacaoPorUsuario(@PathVariable String usuarioId){
		List<SenacCoinMovimentacao> mvs = mvService.buscarMovimentacoesPorUsuario(usuarioId);
		if(mvs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mvs);
	}
	
	@GetMapping
	public ResponseEntity<List<SenacCoinMovimentacao>> buscarTodasMovimentacoes(){
		List<SenacCoinMovimentacao> mvLista = mvService.buscarTodasMovimentacoes();
		if(mvLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(mvLista);
	}
	
	@PostMapping
	public ResponseEntity<SenacCoinMovimentacao> cadastrarMovimentacao(@RequestBody SenacCoinMovimentacao senacCoinMovimentacao){
		SenacCoinMovimentacao mv = mvService.cadastrarMovimentacao(senacCoinMovimentacao);
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SenacCoinMovimentacao> atualizarMovimentacao(@PathVariable Long id, @RequestBody SenacCoinMovimentacao senacCoinMovimentacaoAlterado){
		SenacCoinMovimentacao mv = mvService.atualizarMovimentacao(id, senacCoinMovimentacaoAlterado);
		if(mv == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(mv);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerMovimentacao(@PathVariable Long id){
		String msg = mvService.removerMovimentacao(id);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@PostMapping("/transacao/{tipoTransacao}")
	public ResponseEntity<String> realizarTransacao(@RequestBody SenacCoinMovimentacao senacCoinMovimentacao, @PathVariable boolean tipoTransacao){
		String msg = mvService.realizarTransacao(senacCoinMovimentacao, tipoTransacao);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
