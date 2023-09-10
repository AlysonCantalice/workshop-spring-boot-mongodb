package com.alysonca.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alysonca.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
