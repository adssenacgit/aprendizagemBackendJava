package br.com.aprendizagem.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import br.com.aprendizagem.api.repository.ModuloRepository;
import br.com.aprendizagem.api.repository.UnidadeCurricularRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModuloService {
    
    private UnidadeCurricularRepository unidadeCurricularRepository;

}
