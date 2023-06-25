package com.example.baze.controller;

import com.example.baze.klase.Article;
import com.example.baze.klase.Tag;
import com.example.baze.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/tags")
public class TagController{
    TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(path = {"", "/"})
    Flux<Tag> getTags() {
        return tagService.getTags();
    }

    @GetMapping(value = {"", "/{name}"})
    Mono<Tag> getOneByName(@PathVariable String name) {
        return tagService.getOneByName(name);
    }

    @PostMapping("/add")
    Mono<Tag>  addTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTagById(@PathVariable String id) {
        return tagService.deleteTag(id);
    }
}

