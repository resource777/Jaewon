package com.atm.toonchat.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.toonchat.domain.Article;
import com.atm.toonchat.dto.AddArticleRequest;
import com.atm.toonchat.dto.ArticleResponse;
import com.atm.toonchat.dto.UpdateArticleRequest;
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
	@GetMapping("/api/articles")
	public ResponseEntity<List<ArticleResponse>> findAllArticles(){
		List<ArticleResponse> articles = blogService.findAll()
			.stream()
			.map(ArticleResponse::new) // .map(x -> new ArticleResponse(x))
			.toList();

		return ResponseEntity.ok()
			.body(articles);
	}

	@GetMapping("/api/articles/{id}")
	public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
		Article article = blogService.findById(id);

		return ResponseEntity.ok()
			.body(new ArticleResponse(article));
	}

	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable long id){
		blogService.delete(id);
		return ResponseEntity.ok()
			.build();
	}

	@PutMapping("/api/articles/{id}")
	public ResponseEntity<Article> updateArticle(
		@PathVariable long id,
		@RequestBody UpdateArticleRequest request
	)
	{
		Article updateArticle = blogService.update(id, request);

		return ResponseEntity.ok()
			.body(updateArticle);
	}
}
