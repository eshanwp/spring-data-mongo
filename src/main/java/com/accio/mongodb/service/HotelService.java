package com.accio.mongodb.service;

import com.accio.mongodb.entity.Hotels;
import com.accio.mongodb.entity.QHotels;
import com.accio.mongodb.repository.HotelRepository;
import com.accio.mongodb.utilities.HttpStatusEnum;
import com.accio.mongodb.utilities.ResponsePayload;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Esh
 */
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    private JSONObject createResponse(
            String resultCode,
            String resultShortDesc,
            String resultDescription,
            List resultData,
            int httpStatusCode,
            String httpStatusDesc
    ){
        JSONObject response = new JSONObject();
        response.put("resultCode", resultCode);
        response.put("resultShortDesc", resultShortDesc);
        response.put("resultDescription", resultDescription);
        response.put("resultData", resultData);
        response.put("httpStatusCode", httpStatusCode);
        response.put("httpStatusDesc", httpStatusDesc);
        return response;

    }

    public JSONObject getAllHotels() throws Exception{

        List<Hotels> hotelsList =  hotelRepository.findAll();

        return new ResponsePayload.Builder(HttpStatus.OK)
                .addPayloadAttr("resCode","N/A")
                .addPayloadAttr("resDes","SUCCESSFULLY RETURN THE HOTELS DETAILS")
                .addPayloadAttr("resData", hotelsList)
                .build();

    }

    public JSONObject save(Hotels hotels) throws Exception{
        JSONObject response = new JSONObject();

        hotelRepository.insert(hotels);

        response.put("resultCode", "N/A");
        response.put("resultShortDesc", "HOTEL_HAS_BEEN_SUCCESSFULLY_SAVED");
        response.put("resultDescription", "HOTEL HAS BEEN SUCCESSFULLY SAVED");
        response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
        response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
        return response;

    }

    public JSONObject saveOrUpdate(Hotels hotels) throws Exception {

        JSONObject response = new JSONObject();

        hotelRepository.save(hotels);

        response.put("resultCode", "N/A");
        response.put("resultShortDesc", "HOTEL_HAS_BEEN_SUCCESSFULLY_SAVED");
        response.put("resultDescription", "HOTEL HAS BEEN SUCCESSFULLY SAVED");
        response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
        response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
        return response;

    }

    public JSONObject findById(String id) throws Exception{

        JSONObject response = new JSONObject();

        HashMap hashMap = new HashMap();

        Hotels hotels = hotelRepository.findById(id).get();
        hashMap.put("data", hotels);
        response.put("resultCode", "N/A");
        response.put("resultShortDesc", "SUCCESSFULLY_RETURN_THE HOTELS_DETAILS");
        response.put("resultDescription", "SUCCESSFULLY RETURN_THE HOTELS_DETAILS");
        response.put("resultData", hashMap);
        response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
        response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
        return response;

    }

    /**
     * https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html
     *
     * Please refer the above link for supported keywords for query methods
     */
    public JSONObject findByPricePerNightLessThan(int price) {

        JSONObject response = new JSONObject();

        List<Hotels> hotels = hotelRepository.findByPricePerNightLessThan(price);

        if (hotels.size() !=0){

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "SUCCESSFULLY_RETURN_THE_HOTELS_DETAILS");
            response.put("resultDescription", "SUCCESSFULLY RETURN_THE HOTELS_DETAILS");
            response.put("resultData", hotels);
            response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
            return response;

        }else {

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "HOTEL_NOT_FOUND");
            response.put("resultDescription", "HOTEL NOT FOUND");
            response.put("httpStatusCode", HttpStatusEnum.NOTFOUND.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.NOTFOUND.getDescription());
            return response;

        }



    }

    public JSONObject findByCity(String city) throws Exception {

        JSONObject response = new JSONObject();
        List<Hotels> hotels = this.hotelRepository.findByCity(city);

        if (hotels.size() !=0){

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "SUCCESSFULLY_RETURN_THE_HOTELS_DETAILS");
            response.put("resultDescription", "SUCCESSFULLY RETURN_THE HOTELS_DETAILS");
            response.put("resultData", hotels);
            response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
            return response;

        }else {

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "HOTEL_NOT_FOUND");
            response.put("resultDescription", "HOTEL NOT FOUND");
            response.put("httpStatusCode", HttpStatusEnum.NOTFOUND.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.NOTFOUND.getDescription());
            return response;

        }

    }

    public JSONObject findByCountry(String country) throws Exception {

        JSONObject response = new JSONObject();

        // create a query class (QHotel)
        QHotels qHotel = new QHotels("hotels");

        // using the query class we can create the filters
        BooleanExpression filterByCountry = qHotel.address.any().country.eq(country);

        // we can then pass the filters to the findAll() method
        List<Hotels> hotels = (List<Hotels>) this.hotelRepository.findAll(filterByCountry);

        if (hotels.size() !=0){

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "SUCCESSFULLY_RETURN_THE_HOTELS_DETAILS");
            response.put("resultDescription", "SUCCESSFULLY RETURN_THE HOTELS_DETAILS");
            response.put("resultData", hotels);
            response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
            return response;

        }else {

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "HOTEL_NOT_FOUND");
            response.put("resultDescription", "HOTEL NOT FOUND");
            response.put("httpStatusCode", HttpStatusEnum.NOTFOUND.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.NOTFOUND.getDescription());
            return response;

        }

    }

    public JSONObject getRecommendedHotel() throws Exception {

        JSONObject response = new JSONObject();

        final int maxPrice = 100;
        final int minRating = 7;

        // create a query class (QHotel)
        QHotels qHotel = new QHotels("hotels");

        // using the query class we can create the filters
        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);

        // we can then pass the filters to the findAll() method
        List<Hotels> hotels = (List<Hotels>) this.hotelRepository.findAll(filterByPrice.and(filterByRating));

        if (hotels.size() !=0){

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "SUCCESSFULLY_RETURN_THE_HOTELS_DETAILS");
            response.put("resultDescription", "SUCCESSFULLY RETURN_THE HOTELS_DETAILS");
            response.put("resultData", hotels);
            response.put("httpStatusCode", HttpStatusEnum.OK.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.OK.getDescription());
            return response;

        }else {

            response.put("resultCode", "N/A");
            response.put("resultShortDesc", "HOTEL_NOT_FOUND");
            response.put("resultDescription", "HOTEL NOT FOUND");
            response.put("httpStatusCode", HttpStatusEnum.NOTFOUND.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.NOTFOUND.getDescription());
            return response;

        }

    }
}
