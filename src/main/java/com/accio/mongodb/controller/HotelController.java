package com.accio.mongodb.controller;

import com.accio.mongodb.config.Monitor.LogExecutionTime;
import com.accio.mongodb.entity.Hotels;
import com.accio.mongodb.service.HotelService;
import com.accio.mongodb.utilities.HttpStatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Esh
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private static Logger LOGGER = LogManager.getLogger(HotelController.class.getSimpleName());

    @Autowired
    private HotelService hotelService;

    /**
     * @des get all hotels
     * @param  param goes here
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<String> getAllHotels() throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy:" + "");
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.getAllHotels();
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }


    /**
     * @des save hotel
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> save(@RequestBody Hotels hotels) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy:" + hotels.toString());
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.save(hotels);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }

    /**
     * @des save or update hotel
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @PostMapping(value = "/save-update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> saveOrUpdate(@RequestBody Hotels hotels) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy:" + hotels.toString());
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.saveOrUpdate(hotels);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }


    /**
     * @des find by id
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> findById(@PathVariable String id) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: id" + id);
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.findById(id);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }

    /**
     * @des find by price less than given price
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/price/{price}", produces = "application/json")
    public ResponseEntity<String> findByPricePerNightLessThan(@PathVariable int price) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: price" + price);
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.findByPricePerNightLessThan(price);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }


    /**
     * @des find by hotel according to the city
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/address/{city}", produces = "application/json")
    public ResponseEntity<String> findByCity(@PathVariable String city) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: city" + city);
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.findByCity(city);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }

    /**
     * @des find by hotel according to the country
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/country/{country}", produces = "application/json")
    public ResponseEntity<String> findByCountry(@PathVariable String country) throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: country" + country);
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.findByCountry(country);
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }

    /**
     * @des find by hotel according to the country
     * @return method return data goes here
     * @throws Exception
     */
    @LogExecutionTime
    @GetMapping(value = "/recommended", produces = "application/json")
    public ResponseEntity<String> getRecommendedHotel() throws JSONException {
        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy:" );
        ResponseEntity<String> responseEntity = null;
        JSONObject response = new JSONObject();

        try {
            response = hotelService.getRecommendedHotel();
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());
        } catch (Exception ex){

            response.put("resultCode", HttpStatusEnum.GENERALERROR.getCode());
            response.put("resultShortDesc", HttpStatusEnum.GENERALERROR.getDescription());
            response.put("resultDescription", ex.getMessage());
            response.put("httpStatusCode", HttpStatusEnum.INTERNALERROR.getCode());
            response.put("httpStatusDesc", HttpStatusEnum.INTERNALERROR.getDescription());

            chainLog.append("|FinalResponse:").append(response).append("|Exp:");
            LOGGER.error(chainLog.toString(), ex);
            return responseEntity.status((Integer) response.get("httpStatusCode")).body(response.toString());

        }
    }

}
