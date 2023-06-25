package com.example.baze.controller;

import com.example.baze.klase.Author;
import com.example.baze.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/authors")
public class AuthorController{
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = {"", "/"})
    Flux<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(value = {"", "/{name}"})
    Mono<Author> getOneByName(@PathVariable String name) {
        return authorService.getOneByName(name);
    }

    @PostMapping("/add")
    Mono<Author>  addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAuthorById(@PathVariable String id) {
        return authorService.deleteAuthor(id);
    }
}

