package com.accio.mongodb.repository;

import com.accio.mongodb.entity.Hotels;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Esh
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotels, String> {
    List<Hotels> findByPricePerNightLessThan(int price);
}
