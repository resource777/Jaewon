package com.atm.toonchat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.toonchat.domain.Article;
import com.atm.toonchat.dto.AddArticleRequest;
import com.atm.toonchat.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // http response body에 객체 데이털르 json 형식으로 반환하는 컨트롤러
public class BlogApiController {
	private final BlogService blogService;

	@PostMapping("/api/articles")
	public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
		Article savedArticle = blogService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(savedArticle);
	}
}
