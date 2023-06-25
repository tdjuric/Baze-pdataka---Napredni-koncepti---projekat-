package com.example.baze.service;

import com.example.baze.klase.Author;
import com.example.baze.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public Flux<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    public Mono<Author> getOneByName(String name){
        return authorRepository.findOneByName(name);
    }

    @Transactional
    public Mono<Author> saveAuthor(Author article) {
        return authorRepository.save(article);
    }

    @Transactional
    public Mono<Void> deleteAuthor(String id) {
        return authorRepository.deleteOneById(id)
                .then();
    }


}

