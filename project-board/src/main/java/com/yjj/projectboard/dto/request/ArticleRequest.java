package com.yjj.projectboard.dto.request;

import com.yjj.projectboard.dto.ArticleDto;
import com.yjj.projectboard.dto.HashtagDto;
import com.yjj.projectboard.dto.UserAccountDto;

import java.util.Set;

public record ArticleRequest(
        String title,
        String content
) {

    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return toDto(userAccountDto, null);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto, Set<HashtagDto> hashtagsDtos) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtagsDtos
        );
    }

}
