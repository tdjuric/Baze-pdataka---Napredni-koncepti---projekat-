package com.example.baze.controller;

import com.example.baze.klase.Article;
import com.example.baze.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/articles")
public class ArticleController {
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping(path = {"", "/"})
    Flux<Article> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping("/sort")
    Flux<Article> getArticlesSortedByTitle() {
        return articleService.getArticlesSortedByTitle();
    }

    @GetMapping(value = {"", "/{title}"})
    Mono<Article> getOneByTitle(@PathVariable String title) {
        return articleService.getOneByTitle(title);
    }

    @PostMapping("/add")
    Mono<Article>  addArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteArticleById(@PathVariable String id) {
        return articleService.deleteArticle(id);
    }

    @PostMapping("/update")
    Mono<Article>  updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @GetMapping(value = {"", "/{category}"})
    Mono<Article> getByCategory(@PathVariable String category) {
        return articleService.getByCategory(category);
    }
    

}
