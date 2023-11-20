package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.repository.ChapterAssuntoComentarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChapterAssuntoComentarioService {

    private final ChapterAssuntoComentarioRepository chapterAssuntoComentarioRepository;

    public List<ChapterAssuntoComentario> getAllChapterAssuntoComentario() {
        return chapterAssuntoComentarioRepository.findAll();
    }

    public ChapterAssuntoComentario getChapterAssuntoComentarioById(Integer id) {
        return chapterAssuntoComentarioRepository.findById(id).orElse(null);
    }

    public ChapterAssuntoComentario postChapterAssuntoComentario(ChapterAssuntoComentario chapterAssuntoComentario) {
        return chapterAssuntoComentarioRepository.save(chapterAssuntoComentario);
    }

    public void deleteChapterAssuntoComentarioById(Integer id) {
        chapterAssuntoComentarioRepository.deleteById(id);
    }

    public ChapterAssuntoComentario filterByChapterAssuntoId(Integer chapterAssuntoId) {
        return chapterAssuntoComentarioRepository.findByChapterAssuntoId(chapterAssuntoId);
    }

    public List<ChapterAssuntoComentario> findAllComentarioPai() {
        return chapterAssuntoComentarioRepository.findAllComentarioPai();
    }

    public List<ChapterAssuntoComentario> findAllComentarioPaiByChapterAssuntoId(Integer chapterAssuntoId) {
        return chapterAssuntoComentarioRepository.findAllComentarioPaiByChapterAssuntoId(chapterAssuntoId);
    }
}
