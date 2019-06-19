package com.accio.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Esh
 */
@Repository
public interface PetsRepository extends MongoRepository<Pets, Long> {
}
