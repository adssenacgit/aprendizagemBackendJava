package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.response.RecursoResponse;
import br.com.aprendizagem.api.service.RecursoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("recurso")
@AllArgsConstructor
public class RecursoController {
    private final RecursoService recursoService;

//    @GetMapping
//    public ResponseEntity<List<RecursoResponse>> getAllActiveRecursos() { return recursoService.getActiveRecursos();}

    @GetMapping
    public ResponseEntity<List<RecursoResponse>> getAllActiveRecursosSemArquivos() { return recursoService.getActiveRecursosSemArquivo();}
    @GetMapping(value = "all")
    public ResponseEntity<List<RecursoResponse>> getAllRecursos(){
        return recursoService.getAllRecursos();
    }

    @GetMapping(value = "filtrarRecursosByUsuarioId/{usuarioId}")
    public ResponseEntity<List<RecursoResponse>> getAllActiveRecursosByUsuarioIdSemArquivos(@PathVariable String usuarioId) {
        return recursoService.getActiveRecursosByUsuarioIdSemArquivo(usuarioId);
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna apenas o arquivo no body e o MIME type no http header.")
    public ResponseEntity<byte[]> getRecursoById(@PathVariable Long id){
        Recurso recurso = recursoService.getRecursoById(id);

        if(recurso != null){
            byte[] data = recurso.getArquivo();

            String mimeType = recurso.getMimeType();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(mimeType));

            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}
