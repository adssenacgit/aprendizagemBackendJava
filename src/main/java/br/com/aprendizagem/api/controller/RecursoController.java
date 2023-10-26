package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.request.RecursoRequest;
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

    @PostMapping
    public ResponseEntity<Recurso> createRecurso(@RequestBody RecursoRequest recursoRequest){
        return recursoService.createRecurso(recursoRequest);
    }
    @GetMapping("filtrarRecursosPublicos")
    public ResponseEntity<List<RecursoResponse>> getAllPublicRecursosSemArquivos() { return recursoService.getPublicRecursosSemArquivo();}

    @GetMapping(value = "all")
    public ResponseEntity<List<RecursoResponse>> getAllRecursos(){
        return recursoService.getAllRecursos();
    }

    @GetMapping(value = "filtrarRecursosByUsuarioId/{usuarioId}")
    public ResponseEntity<List<RecursoResponse>> getActiveRecursosByUsuarioIdSemArquivo(@PathVariable String usuarioId) {
        return recursoService.getActiveRecursosByUsuarioIdSemArquivo(usuarioId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id){
        return recursoService.getRecursoById(id);
    }

    @PutMapping("atualizarRecursoNome/{id}")
    public ResponseEntity<Recurso> updateRecursoNomeById(@PathVariable Long id, @RequestBody String nomeAtualizado) {
        return recursoService.updateRecursoNomeById(id, nomeAtualizado);
    }

    @GetMapping(value = "arquivoRecursoById/{id}")
    @ApiOperation(value = "Retorna apenas o arquivo no body e o MIME type no http header.")
    public ResponseEntity<byte[]> getArquivoRecursoById(@PathVariable Long id){
        Recurso recurso = recursoService.getArquivoRecursoById(id);
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

    @PutMapping(value = "atualizarRecursoStatus/{id}/{status}")
    public ResponseEntity<RecursoResponse> atualizarRecursoStatus(@PathVariable Long id, @PathVariable Integer status) {
        return recursoService.atualizarRecursoStatus(id, status);
    }
}
