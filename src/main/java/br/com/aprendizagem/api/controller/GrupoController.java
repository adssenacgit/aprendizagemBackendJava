package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Grupo;
import br.com.aprendizagem.api.response.GrupoResponse;
import br.com.aprendizagem.api.service.GrupoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "grupo")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }


    @GetMapping
    public ResponseEntity<List<GrupoResponse>> getAllGrupos(){
        return grupoService.getAllGrupos();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Grupo encontrado."),
            @ApiResponse(code = 404, message = "Não encontrado."),
    })
    public ResponseEntity<GrupoResponse> getGrupoById(@PathVariable Long id){
        return grupoService.getGrupoById(id);
    }

    @GetMapping("/getGrupoByEstudanteId/{estudanteId}")
    public ResponseEntity<List<GrupoResponse>> getGrupoByEstudanteId(@PathVariable Long estudanteId) {
        List<Grupo> grupos = grupoService.getGruposByEstudanteId(estudanteId);
        if(grupos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GrupoResponse.of(grupos));
    }

    @GetMapping("/getGrupoByPeriodoAtivoByEstudanteId/{estudanteId}")
    public ResponseEntity<List<GrupoResponse>> getGrupoByPeriodoAtivoByEstudanteId(@PathVariable Long estudanteId) {
        List<Grupo> grupos = grupoService.getGruposByPeriodoAtivoByEstudanteId(estudanteId);
        if(grupos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GrupoResponse.of(grupos));
    }

    @GetMapping("/getGrupoByPeriodoAtivoByProfessorId/{professorId}")
    public ResponseEntity<List<GrupoResponse>> getGruposByPeriodoAtivoByProfessorId(@PathVariable Long professorId){
        List<Grupo> grupos = grupoService.getGruposByPeriodoAtivoByProfessorId(professorId);
        if(grupos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GrupoResponse.of(grupos));
    }
}
