package com.example.baze.repository;

import com.example.baze.klase.Article;
import com.example.baze.klase.Author;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorRepository extends ReactiveNeo4jRepository<Author, String> {

    @Query("MATCH (a:Author {name: $name}) RETURN a")
    Mono<Author> findOneByName(String name);

    @Query("MATCH (a:Author {id: $id}) DELETE a")
    Mono<Article> deleteOneById(@Param("id") String id);

    @Query("MATCH (a:Author) RETURN a")
    Flux<Author> findAll();



}