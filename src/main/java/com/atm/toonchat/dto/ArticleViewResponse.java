package com.atm.toonchat.dto;

import java.time.LocalDateTime;

import com.atm.toonchat.domain.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleViewResponse {
	private Long id;
	private String title;
	private String content;
	private LocalDateTime createdAt;

	public ArticleViewResponse(Article article){
		this.id = article.getId();
		this.title = article.getTitle();
		this.content = article.getContent();
		this.createdAt = article.getCreatedAt();
	}
}
