package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.response.EncontroAlunoResponse;
import br.com.aprendizagem.api.response.EncontroResponse;
import br.com.aprendizagem.api.response.EncontroSituacaoResponse;
import br.com.aprendizagem.api.service.EncontroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("encontro")
@AllArgsConstructor
public class EncontroController {
    private final EncontroService encontroService;

    @GetMapping
    public ResponseEntity<List<Encontro>> getAllEncontros() {
        return encontroService.getAllEncontros();
    };

    @GetMapping("filtrarByGrupoId/{grupoId}")
    public ResponseEntity<List<EncontroResponse>> getEncontrosByGrupoId(@PathVariable Long grupoId){
        return encontroService.getEncontrosByGrupoId(grupoId);
    }

    @GetMapping("filtrarByGrupoIdByEstudanteId/{grupoId}")
    public ResponseEntity<List<EncontroAlunoResponse>> getEncontrosByGrupoIdByEstudanteId(@PathVariable Long grupoId, @PathVariable Long estudanteId){
        return encontroService.getEncontrosByGrupoIdByEstudanteId(grupoId, estudanteId);
    }

//    @GetMapping("filtrarEncontrosComSituacaoByGrupoId")
//    public ResponseEntity<List<EncontroSituacaoResponse>> getEncontrosSituacaoByGrupoId(@PathVariable Long grupoId){
//        return encontroService.getEncontrosSituacaoByGrupoId(grupoId);
//    }
}
