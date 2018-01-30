package com.jvmcon.beers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeerRepository extends MongoRepository<Beer, String>{
}
