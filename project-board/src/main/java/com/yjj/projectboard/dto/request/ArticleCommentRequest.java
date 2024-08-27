package com.yjj.projectboard.dto.request;

import com.yjj.projectboard.dto.ArticleCommentDto;
import com.yjj.projectboard.dto.ArticleDto;
import com.yjj.projectboard.dto.UserAccountDto;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.yjj.projectboard.domain.ArticleComment}
 */
public record ArticleCommentRequest
        (Long articleId,
         Long parentCommentId,
         String content) {
    public static ArticleCommentRequest of(Long articleId, String content) {
        return ArticleCommentRequest.of(articleId, null, content);
    }

    public static ArticleCommentRequest of(Long articleId,Long parentCommentId, String content) {
        return new ArticleCommentRequest(articleId, parentCommentId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId, userAccountDto, parentCommentId, content
        );
    }
}