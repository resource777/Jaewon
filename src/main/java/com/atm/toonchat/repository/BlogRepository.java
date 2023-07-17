package com.atm.toonchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.toonchat.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
