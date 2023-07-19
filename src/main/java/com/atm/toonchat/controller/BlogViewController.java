package com.atm.toonchat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atm.toonchat.dto.ArticleListViewResponse;
import com.atm.toonchat.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
	private final BlogService blogService;

	@GetMapping("/articles")
	public String getArticles(Model model){
		List<ArticleListViewResponse> articles = blogService.findAll()
			.stream()
			.map(ArticleListViewResponse::new)
			.toList();
		model.addAttribute("articles",articles);

		return "articleList";
	}
}
