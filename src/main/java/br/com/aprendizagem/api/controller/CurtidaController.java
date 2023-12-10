package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Curtida;
import br.com.aprendizagem.api.service.CurtidaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtida")
@AllArgsConstructor
public class CurtidaController {

    private final CurtidaService curtidaService;

    @GetMapping
    public ResponseEntity<List<Curtida>> getAllCurtidas() {
        return ResponseEntity.ok().body(curtidaService.getAllCurtidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curtida> getCurtidaById(@PathVariable Integer id) {
        Curtida curtida = curtidaService.getCurtidaById(id);
        if (curtida != null) {
            return ResponseEntity.ok().body(curtida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Curtida> postCurtida(@RequestBody Curtida curtida) {
        return ResponseEntity.ok().body(curtidaService.postCurtida(curtida));
    }



}
