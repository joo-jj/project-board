package com.yjj.projectboard.service;

import com.yjj.projectboard.domain.ArticleComment;
import com.yjj.projectboard.dto.ArticleCommentDto;
import com.yjj.projectboard.repository.ArticleCommentRepository;
import com.yjj.projectboard.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;

//    @Transactional(readOnly = true)
//    public Page<ArticleCommentDto> searchArticleComment(Long articleId) {
//        return Page.empty();
//    }

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .toList();
    }
    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            articleCommentRepository.save(dto.toEntity(articleRepository.getReferenceById(dto.articleId())));
        }catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글의 게시글르 찾을 수 없습니다 - dto: {}", dto);
        }
    }
    public void updateArticleComment(ArticleCommentDto dto) {
        try{
            ArticleComment articleComment = articleCommentRepository.getReferenceById(dto.id());
            if(dto.content() != null) articleComment.setContent(dto.content());
        }catch (EntityNotFoundException e) {
            log.warn("댓글 업데이트 실패. 댓글을 찾을 수 없습니ㅏㄷ. - dto: {}", dto);
        }
    }
    public void deleteArticleComment(Long articleCommentId) {
        articleCommentRepository.deleteById(articleCommentId);
    }
}
