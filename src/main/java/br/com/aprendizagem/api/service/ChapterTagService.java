package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.repository.ChapterTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ChapterTagService {
    private final ChapterTagRepository chapterTagRepository;

    public List<ChapterTag> getAllChapterTags() {
        return chapterTagRepository.findAll();
    }

    public List<ChapterTag> getAllActiveChapterTags() {
        List<ChapterTag> chapterTags = new ArrayList<>();
        for (ChapterTag chapterTag : chapterTagRepository.findAll()) {
            if (chapterTag.getStatus() == 1) {
                chapterTags.add(chapterTag);
            }
        }
        return chapterTags;
    }

    public ChapterTag getChapterTagById(Long id) {
        ChapterTag chapterTag = chapterTagRepository.findById(id).orElse(null);
        if (chapterTag != null && chapterTag.getStatus() == 1) {
            return chapterTag;
        }
        return null;
    }

    public ChapterTag postChapterTag(ChapterTag chapterTag) {
        return chapterTagRepository.save(chapterTag);
    }


    public void deleteChapterTag(Long id) {
        ChapterTag chapterTag = chapterTagRepository.findById(id).orElse(null);
        if (chapterTag != null) {
            chapterTag.setStatus(0);
            chapterTagRepository.save(chapterTag);
        }
    }



}
