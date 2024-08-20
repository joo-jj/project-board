package com.yjj.projectboard.dto.request;

import com.yjj.projectboard.dto.ArticleCommentDto;
import com.yjj.projectboard.dto.ArticleDto;
import com.yjj.projectboard.dto.UserAccountDto;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.yjj.projectboard.domain.ArticleComment}
 */
public record ArticleCommentRequest(Long articleId, String content) {
    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId, userAccountDto, content
        );
    }
}