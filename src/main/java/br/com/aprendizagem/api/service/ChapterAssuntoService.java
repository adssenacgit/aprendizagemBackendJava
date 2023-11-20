package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.DTO.ChapterAssuntoComentariosPaiDto;
import br.com.aprendizagem.api.DTO.ChapterAssuntoTotalCurtidasDto;
import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
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

    private final ChapterAssuntoComentarioService chapterAssuntoComentarioService;

    @Transactional
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto() {
        List<ChapterAssunto> assuntos = chapterAssuntoRepository.getAllChapterAssunto();
        if (assuntos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assuntos);
    }

    @Transactional
    public ResponseEntity<List<ChapterAssuntoComentariosPaiDto>> getAllChapterAssuntoWithComentariosPai() {
        List<ChapterAssunto> chapterAssuntos = chapterAssuntoRepository.getAllChapterAssunto();
        List<ChapterAssuntoComentariosPaiDto> chapterAssuntoDtos = new ArrayList<>();
        for (ChapterAssunto chapterAssunto : chapterAssuntos) {
            ChapterAssuntoComentariosPaiDto chapterAssuntoDTO = new ChapterAssuntoComentariosPaiDto();
            buildDto(chapterAssunto, chapterAssuntoDTO);
            chapterAssuntoDTO.setComentariosPais(chapterAssuntoComentarioService.findAllComentarioPaiByChapterAssuntoId(chapterAssunto.getId()));
            chapterAssuntoDtos.add(chapterAssuntoDTO);
        }
        return ResponseEntity.ok().body(chapterAssuntoDtos);
    }


    @Transactional
    public ChapterAssunto getChapterAssuntoById(Integer id) {
        return chapterAssuntoRepository.findById(id).orElse(null);
    }

    @Transactional
    public ChapterAssuntoTotalCurtidasDto getChapterAssuntoByIdWithTotalComentarios(Integer id) {
        ChapterAssunto chapterAssunto = chapterAssuntoRepository.findById(id).orElse(null);
        ChapterAssuntoTotalCurtidasDto chapterAssuntoDTO = new ChapterAssuntoTotalCurtidasDto();
        if (chapterAssunto != null) {
            buildDto(chapterAssunto, chapterAssuntoDTO);
            chapterAssuntoDTO.setTotalComentarios(chapterAssunto.getComentarios().size());
        }

        return chapterAssuntoDTO;
    }

    @Transactional
    public ChapterAssuntoComentariosPaiDto getChapterAssuntoByIdWithComentariosPai(Integer id) {
        ChapterAssunto chapterAssunto = chapterAssuntoRepository.findById(id).orElse(null);
        ChapterAssuntoComentariosPaiDto chapterAssuntoDTO = new ChapterAssuntoComentariosPaiDto();
        if (chapterAssunto != null) {
            buildDto(chapterAssunto, chapterAssuntoDTO);
            chapterAssuntoDTO.setComentariosPais(chapterAssuntoComentarioService.findAllComentarioPai());
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
    public ResponseEntity<List<ChapterAssuntoTotalCurtidasDto>> getAllChapterAssuntoWithTotalComentarios() {
        List<ChapterAssunto> chapterAssuntos = chapterAssuntoRepository.getAllChapterAssunto();
        List<ChapterAssuntoTotalCurtidasDto> chapterAssuntoDtos = new ArrayList<>();
        for (ChapterAssunto chapterAssunto : chapterAssuntos) {
            ChapterAssuntoTotalCurtidasDto chapterAssuntoDTO = new ChapterAssuntoTotalCurtidasDto();
            buildDto(chapterAssunto, chapterAssuntoDTO);
            chapterAssuntoDTO.setTotalComentarios(chapterAssunto.getComentarios().size());
            chapterAssuntoDtos.add(chapterAssuntoDTO);
        }
        return ResponseEntity.ok().body(chapterAssuntoDtos);
    }

    public void deleteChapterAssunto(Integer id) {
        chapterAssuntoRepository.deleteById(id);
    }

    private void buildDto(ChapterAssunto chapterAssunto, ChapterAssuntoTotalCurtidasDto chapterAssuntoDto) {
        chapterAssuntoDto.setId(chapterAssunto.getId());
        chapterAssuntoDto.setDataCadastro(chapterAssunto.getDataCadastro());
        chapterAssuntoDto.setTitulo(chapterAssunto.getTitulo());
        chapterAssuntoDto.setDescricao(chapterAssunto.getDescricao());
        chapterAssuntoDto.setImagem(chapterAssunto.getImagem());
        chapterAssuntoDto.setContadorVisualizacao(chapterAssunto.getContadorVisualizacao());
        chapterAssuntoDto.setStatus(chapterAssunto.getStatus());
        chapterAssuntoDto.setVerificacao(chapterAssunto.getVerificacao());
        chapterAssuntoDto.setChapter(chapterAssunto.getChapter());
        chapterAssuntoDto.setUsuario(chapterAssunto.getUsuario());
        chapterAssuntoDto.setUsuarioVerificacao(chapterAssunto.getUsuarioVerificacao());
        chapterAssuntoDto.setTags(chapterAssunto.getTags());


    }

    private void buildDto(ChapterAssunto chapterAssunto, ChapterAssuntoComentariosPaiDto chapterAssuntoDTO) {
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
    }
}






















