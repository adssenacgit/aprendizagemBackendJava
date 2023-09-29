package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.response.RecursoResponse;
import br.com.aprendizagem.api.service.RecursoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("recurso")
@AllArgsConstructor
public class RecursoController {
    private final RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<RecursoResponse>> getAllRecursos(){
        return recursoService.getAllRecursos();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna apenas o arquivo no body e o MIME type no http header.")
    public ResponseEntity<byte[]> getRecursoById(@PathVariable Long id){
        Recurso recurso = recursoService.getRecursoById(id);

        if(recurso != null){
            byte[] data = recurso.getArquivo();

            String mimeType = determineMimeType(data);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(mimeType));

            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    private String determineMimeType(byte[] data) {
        Tika tika = new Tika();
        return tika.detect(data); // Detect MIME type based on binary data
    }
}
