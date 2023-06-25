package com.example.baze.service;

import com.example.baze.klase.Article;
import com.example.baze.klase.Tag;
import com.example.baze.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    @Transactional
    public Flux<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Transactional
    public Mono<Tag> getOneByName(String name){
        return tagRepository.findOneByName(name);
    }

    @Transactional
    public Mono<Tag> saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public Mono<Void> deleteTag(String id) {
        return tagRepository.deleteOneById(id)
                .then();
    }


}

