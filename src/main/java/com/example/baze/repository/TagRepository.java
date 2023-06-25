package com.example.baze.repository;
;
import com.example.baze.klase.Tag;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TagRepository extends ReactiveNeo4jRepository<Tag, String> {
    @Query("MATCH (t:Tag {name: $name}) RETURN t")
    Mono<Tag> findOneByName(String name);

    @Query("MATCH (t:Tag {id: $id}) DELETE t")
    Mono<Tag> deleteOneById(@Param("id") String id);

    @Query("MATCH (t:Tag) RETURN t")
    Flux<Tag> findAll();


}
