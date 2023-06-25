package com.example.baze.service;


import com.example.baze.klase.Article;
import com.example.baze.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Transactional
    public Flux<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Transactional
    public Flux<Article> getArticlesSortedByTitle() {
        return articleRepository.findAllSortedByTitle();
    }

    @Transactional
    public Mono<Article> getOneByTitle(String title){
        return articleRepository.findOneByTitle(title);
    }


    @Transactional
    public Mono<Article> saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    public Mono<Void> deleteArticle(String id) {
        return articleRepository.deleteOneById(id)
                .then();
    }

    @Transactional
    public Mono<Article> updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    public Mono<Article> getByCategory(String category){
        return articleRepository.findByCategory(category);
    }


}

