package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.DTO.ChapterAssuntoDTO;
import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.repository.ChapterAssuntoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChapterAssuntoService {

    private final ChapterAssuntoRepository chapterAssuntoRepository;

    @Transactional
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto() {
        List<ChapterAssunto> assuntos = chapterAssuntoRepository.getAllChapterAssunto();
        if (assuntos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assuntos);
    }


    @Transactional
    public ChapterAssunto getChapterAssuntoById(Integer id) {
        return chapterAssuntoRepository.findById(id).orElse(null);
    }

    @Transactional
    public ChapterAssuntoDTO getChapterAssuntoByIdWithTotalComentarios(Integer id) {
        ChapterAssunto chapterAssunto = chapterAssuntoRepository.findById(id).orElse(null);
        ChapterAssuntoDTO chapterAssuntoDTO = new ChapterAssuntoDTO();
        if (chapterAssunto != null) {
            buildDTO(chapterAssunto, chapterAssuntoDTO);
        }

        return chapterAssuntoDTO;
    }


    @Transactional
    public ChapterAssunto postChapterAssunto(ChapterAssunto chapterAssunto) {
        return chapterAssuntoRepository.save(chapterAssunto);
    }

    @Transactional
    public ResponseEntity<List<ChapterAssunto>> filterChapterAssuntosByChapterId(Integer chapterId) {
        List<ChapterAssunto> chapterAssuntos = chapterAssuntoRepository.findByChapterId(chapterId);
        if (!chapterAssuntos.isEmpty()) {
            return ResponseEntity.ok(chapterAssuntos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<List<ChapterAssuntoDTO>> getAllChapterAssuntoWithTotalComentarios() {
        List<ChapterAssunto> chapterAssuntos = chapterAssuntoRepository.getAllChapterAssunto();
        List<ChapterAssuntoDTO> chapterAssuntoDTOS = new ArrayList<>();
        for (ChapterAssunto chapterAssunto : chapterAssuntos) {
            ChapterAssuntoDTO chapterAssuntoDTO = new ChapterAssuntoDTO();
            buildDTO(chapterAssunto, chapterAssuntoDTO);
            chapterAssuntoDTOS.add(chapterAssuntoDTO);
        }
        return ResponseEntity.ok().body(chapterAssuntoDTOS);
    }

    private void buildDTO(ChapterAssunto chapterAssunto, ChapterAssuntoDTO chapterAssuntoDTO) {
        chapterAssuntoDTO.setId(chapterAssunto.getId());
        chapterAssuntoDTO.setDataCadastro(chapterAssunto.getDataCadastro());
        chapterAssuntoDTO.setTitulo(chapterAssunto.getTitulo());
        chapterAssuntoDTO.setDescricao(chapterAssunto.getDescricao());
        chapterAssuntoDTO.setImagem(chapterAssunto.getImagem());
        chapterAssuntoDTO.setContadorVisualizacao(chapterAssunto.getContadorVisualizacao());
        chapterAssuntoDTO.setStatus(chapterAssunto.getStatus());
        chapterAssuntoDTO.setVerificacao(chapterAssunto.getVerificacao());
        chapterAssuntoDTO.setChapter(chapterAssunto.getChapter());
        chapterAssuntoDTO.setUsuario(chapterAssunto.getUsuario());
        chapterAssuntoDTO.setUsuarioVerificacao(chapterAssunto.getUsuarioVerificacao());
        chapterAssuntoDTO.setTags(chapterAssunto.getTags());
        chapterAssuntoDTO.setTotalComentarios(chapterAssunto.getComentarios().size());

    }
}






















