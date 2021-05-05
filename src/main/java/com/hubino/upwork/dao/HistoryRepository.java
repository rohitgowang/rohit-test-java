package com.hubino.upwork.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.History;

public interface HistoryRepository extends MongoRepository<History, String> {

}
