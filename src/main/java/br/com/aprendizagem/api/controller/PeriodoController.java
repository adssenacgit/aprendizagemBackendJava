package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Periodo;
import br.com.aprendizagem.api.service.PeriodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("periodo")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> getAllPeriodos(){
        List<Periodo> periodos = periodoService.getAllPeriodos();
        if(periodos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(periodos);
    }

    @GetMapping("/periodo-ativo")
    public ResponseEntity<Periodo> getPeriodoAtivo(){
        Periodo periodo = periodoService.getPeriodoAtivo();
        if(periodo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(periodo);
    }
}
