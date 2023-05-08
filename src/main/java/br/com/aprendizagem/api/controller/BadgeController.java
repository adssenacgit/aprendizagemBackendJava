package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.entity.Badge;

import br.com.aprendizagem.api.service.BadgeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("badge")
public class BadgeController {
	@Autowired
	private BadgeService rcService;
	
	@GetMapping("/badgeListar/{badgeId}")
	@ApiOperation(value = "Listar badge por id")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Badge encontrado."),
			@ApiResponse(code = 404, message = "Nenhuma badge encontrado."),
	})
	
	public ResponseEntity<List<Badge>> buscarBadgeIdTodos(@PathVariable Integer badgeId){
		
		List<Badge> rcLista = rcService.buscarBadgeId(badgeId);
		
		if(rcLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(rcLista);
	}
	
	
	@GetMapping("/badgeListarNivel/{badgeNivelId}")
	@ApiOperation(value = "Listar badge por nivel")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Badge encontrado."),
			@ApiResponse(code = 404, message = "Nenhuma badge encontrado."),
	})
	
public ResponseEntity<List<Badge>> buscarBadgeNivelIdTodos(@PathVariable Integer badgeNivelId){
		
		List<Badge> rcLista = rcService.buscarBadgeNivelId(badgeNivelId);
		
		if(rcLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(rcLista);
	}
}
