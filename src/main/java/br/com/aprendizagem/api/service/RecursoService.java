package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
import br.com.aprendizagem.api.repository.RecursoRepository;
import br.com.aprendizagem.api.repository.UsuarioRepository;
import br.com.aprendizagem.api.request.RecursoRequest;
import br.com.aprendizagem.api.response.RecursoResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecursoService {
    private final RecursoRepository recursoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getAllRecursos() {
        List<Recurso> recursos = recursoRepository.findAll();
        if( recursos.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RecursoResponse.of(recursos));
    }

    @Transactional
    public Recurso getArquivoRecursoById(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }

    @Transactional
    public ResponseEntity<Recurso> getRecursoById(Long id) {
        Recurso recurso = recursoRepository.findById(id).orElse(null);
        if( recurso != null)
            return ResponseEntity.ok(recurso);
        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursos() {
        List<Recurso> recursos = recursoRepository.getActiveRecursos();
        if( recursos.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RecursoResponse.of(recursos));
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursosSemArquivo() {
        List<RecursoResponse> recursos = recursoRepository.getActiveRecursosSemArquivo();

        if (recursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recursos);
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursosByUsuarioIdSemArquivo(String usuarioId) {

        List<RecursoResponse> recursos = recursoRepository.getActiveRecursosByUsuarioIdSemArquivo(usuarioId);
        if (recursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recursos);
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getPublicRecursosSemArquivo() {
        List<RecursoResponse> recursos = recursoRepository.getPublicRecursosSemArquivo();

        if (recursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(recursos);
    }

    @Transactional
    public ResponseEntity<RecursoResponse> atualizarRecursoStatus(Long id, Integer status) {
        Optional<Recurso> optionalRecurso = recursoRepository.findById(id);

        if (optionalRecurso.isPresent()) {
            Recurso recursoExistente = optionalRecurso.get();
            recursoExistente.setStatus(status);
            Recurso recursoAtualizado = recursoRepository.save(recursoExistente);
            return ResponseEntity.ok(RecursoResponse.of(recursoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Recurso> updateRecursoNomeById(Long id, String nomeAtualizado) {
        Optional<Recurso> optionalRecurso = recursoRepository.findById(id);

        if (optionalRecurso.isPresent()) {
            Recurso recursoExistente = optionalRecurso.get();
            recursoExistente.setNomeArquivo(nomeAtualizado);
            Recurso recursoAtualizado = recursoRepository.save(recursoExistente);
            return ResponseEntity.ok(recursoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Recurso> createRecurso(RecursoRequest recursoRequest) {
        Recurso recurso = new Recurso();
        recurso.setDescricao(recursoRequest.getDescricao());
        recurso.setNomeArquivo(recursoRequest.getNomeArquivo());
        recurso.setArquivo(recursoRequest.getArquivo());
        recurso.setMimeType(recursoRequest.getMimeType());
        recurso.setDataCadastro(recursoRequest.getDataCadastro());
        recurso.setStatus(recursoRequest.getStatus());
        recurso.setTamanho(recursoRequest.getTamanho());

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(recursoRequest.getUsuarioId());
        if (usuarioOptional.isPresent()) {
            recurso.setUsuario(usuarioOptional.get());
            return ResponseEntity.ok(recursoRepository.save(recurso));
        } else {
            throw new IllegalArgumentException("Id de usuário inválido");
        }
    }
    @Transactional
    public ResponseEntity<Recurso> updateRecurso(Long id, RecursoRequest recursoAtualizado) {
        Optional<Recurso> optRecurso = recursoRepository.findById(id);
        if (optRecurso.isPresent()) {
            Recurso existingRecurso = optRecurso.get();
            existingRecurso.setDescricao(recursoAtualizado.getDescricao());
            existingRecurso.setNomeArquivo(recursoAtualizado.getNomeArquivo());
            existingRecurso.setArquivo(recursoAtualizado.getArquivo());
            existingRecurso.setMimeType(recursoAtualizado.getMimeType());
            existingRecurso.setStatus(recursoAtualizado.getStatus());
            existingRecurso.setTamanho(recursoAtualizado.getTamanho());
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(recursoAtualizado.getUsuarioId());
            if (usuarioOptional.isPresent()) {
                existingRecurso.setUsuario(usuarioOptional.get());
            } else {
                throw new IllegalArgumentException("Id de usuário inválido");
            }
            return ResponseEntity.ok(recursoRepository.save(existingRecurso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
