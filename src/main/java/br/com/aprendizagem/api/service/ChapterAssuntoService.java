package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.DTO.ChapterAssuntoDto;
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
    public ChapterAssuntoDto getChapterAssuntoDtoById(Integer id) {
        ChapterAssunto chapterAssunto = chapterAssuntoRepository.findById(id).orElse(null);
        ChapterAssuntoDto chapterAssuntoDTO = new ChapterAssuntoDto();
        if (chapterAssunto != null) {
            buildDto(chapterAssunto, chapterAssuntoDTO);
        }
        return chapterAssuntoDTO;
    }

    @Transactional
    public ChapterAssunto getChapterAssuntoById(Integer id) {
        return chapterAssuntoRepository.findById(id).orElse(null);
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
    public ResponseEntity<List<ChapterAssuntoDto>> getAllChapterAssuntoDto() {
        List<ChapterAssunto> chapterAssuntos = chapterAssuntoRepository.getAllChapterAssunto();
        List<ChapterAssuntoDto> chapterAssuntoDtos = new ArrayList<>();
        for (ChapterAssunto chapterAssunto : chapterAssuntos) {
            ChapterAssuntoDto chapterAssuntoDto = new ChapterAssuntoDto();
            buildDto(chapterAssunto, chapterAssuntoDto);
            chapterAssuntoDto.setTotalComentarios(chapterAssunto.getComentarios().size());
            chapterAssuntoDtos.add(chapterAssuntoDto);
        }
        return ResponseEntity.ok().body(chapterAssuntoDtos);
    }

    public void deleteChapterAssunto(Integer id) {
        chapterAssuntoRepository.deleteById(id);
    }


    private void buildDto(ChapterAssunto chapterAssunto, ChapterAssuntoDto chapterAssuntoDto) {
        chapterAssuntoDto.setId(chapterAssunto.getId());
        chapterAssuntoDto.setDataCadastro(chapterAssunto.getDataCadastro());
        chapterAssuntoDto.setTitulo(chapterAssunto.getTitulo());
        chapterAssuntoDto.setDescricao(chapterAssunto.getDescricao());
        chapterAssuntoDto.setImagem(chapterAssunto.getImagem());
        chapterAssuntoDto.setContadorVisualizacao(chapterAssunto.getContadorVisualizacao());
        chapterAssuntoDto.setStatus(chapterAssunto.getStatus());
        chapterAssuntoDto.setVerificacao(chapterAssunto.getVerificacao());
        chapterAssuntoDto.setChapterId(chapterAssunto.getChapter().getId());
        chapterAssuntoDto.setUsuario(chapterAssunto.getUsuario());
        chapterAssuntoDto.setChapterNome(chapterAssunto.getChapter().getNome());
        if (chapterAssunto.getUsuarioVerificacao() != null) {
            chapterAssuntoDto.setUsuarioVerificacaoId(chapterAssunto.getUsuarioVerificacao().getId());
        }
        chapterAssuntoDto.setTags(chapterAssunto.getTags());
        chapterAssuntoDto.setTotalComentarios(chapterAssunto.getComentarios().size());
    }
}






















