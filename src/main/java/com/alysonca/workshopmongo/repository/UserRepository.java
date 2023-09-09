package com.alysonca.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alysonca.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
