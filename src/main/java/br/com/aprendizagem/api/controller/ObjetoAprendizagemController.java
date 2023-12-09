package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.service.ObjetoAprendizagemService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("objetoAprendizagem")
@AllArgsConstructor
public class ObjetoAprendizagemController {
    private final ObjetoAprendizagemService objetoAprendizagemService;

    @GetMapping
    public ResponseEntity<List<ObjetoAprendizagem>> getAllObjetosAprendizagem() {
        return objetoAprendizagemService.getAllObjetosAprendizagem();
    }

    @GetMapping(value = "obterObjetoArquivoPorId/{objetoId}")
    @ApiOperation(value = "Retorna apenas o arquivo no body.")
    public ResponseEntity<byte[]> getArquivoObjetoById(@PathVariable Long objetoId){
        ObjetoAprendizagem objetoAprendizagem = objetoAprendizagemService.getArquivoObjetoById(objetoId);
        if(objetoAprendizagem != null){
            if (objetoAprendizagem.getArquivo() != null){
                byte[] data = objetoAprendizagem.getArquivo();
                return ResponseEntity.ok(data);
            }
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "obterObjetoComRecursosPorId/{objetoId}")
    public ResponseEntity<ObjetoAprendizagem> getObjetoWithRecursosByObjetoId(@PathVariable Long objetoId){
        return objetoAprendizagemService.getObjetoWithRecursosByObjetoId(objetoId);
    }

    @PostMapping
    public ResponseEntity<ObjetoAprendizagem> postObjeto(@RequestBody ObjetoAprendizagem objeto) {
        return objetoAprendizagemService.createObjeto(objeto);
    }
}
