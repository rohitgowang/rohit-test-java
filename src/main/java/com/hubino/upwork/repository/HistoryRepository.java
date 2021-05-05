package com.hubino.upwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.History;

public interface HistoryRepository extends MongoRepository<History, String> {

}
