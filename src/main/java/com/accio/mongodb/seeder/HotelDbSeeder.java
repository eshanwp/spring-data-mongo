package com.accio.mongodb.seeder;

import com.accio.mongodb.entity.Address;
import com.accio.mongodb.entity.Hotels;
import com.accio.mongodb.entity.Review;
import com.accio.mongodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Esh
 */
@Component
public class HotelDbSeeder implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelDbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Hotels marriot = new Hotels(
                "Marriot",
                130,
                Arrays.asList(
                        new Address("Paris", "Paris")
                ),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotels ibis = new Hotels(
                "Ibis",
                90,
                Arrays.asList(
                        new Address("Bucharest", "Romania")
                ),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotels sofitel = new Hotels(
                "Sofitel",
                200,
                Arrays.asList(
                        new Address("Rome", "Italy")
                ),
                new ArrayList<>()
        );

        // drop all hotels
//        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotels> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.insert(hotels);

    }
}
