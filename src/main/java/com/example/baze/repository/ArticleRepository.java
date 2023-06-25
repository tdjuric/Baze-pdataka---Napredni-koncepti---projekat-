package com.example.baze.repository;

import com.example.baze.klase.Article;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ArticleRepository extends ReactiveNeo4jRepository<Article, String> {
    @Query("MATCH (a:Article {title: $title}) RETURN a")
    Mono<Article> findOneByTitle(String title);

    @Query("MATCH (a:Article {category: $category}) RETURN a")
    Mono<Article> findByCategory(@Param("category") String category);

    @Query("MATCH (a:Article {id: $id}) DELETE a")
    Mono<Article> deleteOneById(@Param("id") String id);

    @Query("MATCH (a:Article) RETURN a")
    Flux<Article> findAll();

    @Query("MATCH (a:Article) RETURN a ORDER BY a.title ASC")
    Flux<Article> findAllSortedByTitle();






}