package com.accio.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Esh
 */

@Document(collection = "hotels")
public class Hotels {

    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pricePerNight;
    private List<Address> address = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public Hotels(String name, int pricePerNight, List<Address> address, List<Review> reviews) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", address=" + address +
                ", reviews=" + reviews +
                '}';
    }
}
