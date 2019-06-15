package com.accio.mongodb.repository;

import com.accio.mongodb.entity.Hotels;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Esh
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotels, String>, QuerydslPredicateExecutor<Hotels> {
    List<Hotels> findByPricePerNightLessThan(int price);

    @Query(value = "{address.city:?0}")
    List<Hotels> findByCity(String city);
}
