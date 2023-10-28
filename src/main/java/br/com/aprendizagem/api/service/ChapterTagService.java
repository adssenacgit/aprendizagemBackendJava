package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.repository.ChapterTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ChapterTagService {
    private final ChapterTagRepository chapterTagRepository;

    @Transactional
    public List<ChapterTag> getAllChapterTags() {
        return chapterTagRepository.findAll();
    }

    @Transactional
    public List<ChapterTag> getAllActiveChapterTags() {
        List<ChapterTag> chapterTags = new ArrayList<>();
        for (ChapterTag chapterTag : chapterTagRepository.findAll()) {
            if (chapterTag.getStatus() == 1) {
                chapterTags.add(chapterTag);
            }
        }
        return chapterTags;
    }

    @Transactional
    public ChapterTag getChapterTagById(Long id) {
        ChapterTag chapterTag = chapterTagRepository.findById(id).orElse(null);
        if (chapterTag != null && chapterTag.getStatus() == 1) {
            return chapterTag;
        }
        return null;
    }

    @Transactional
    public ChapterTag postChapterTag(ChapterTag chapterTag) {
        return chapterTagRepository.save(chapterTag);
    }

    @Transactional
    public void deleteChapterTag(Long id) {
        ChapterTag chapterTag = chapterTagRepository.findById(id).orElse(null);
        if (chapterTag != null) {
            chapterTag.setStatus(0);
            chapterTagRepository.save(chapterTag);
        }
    }



}
