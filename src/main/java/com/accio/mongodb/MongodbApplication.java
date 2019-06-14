package com.accio.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@SpringBootApplication
public class MongodbApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongodbApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    static {
        try {
            System.setProperty("hostAddress", InetAddress.getLocalHost().getHostAddress().replaceAll("\\.", "_"));
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+0530"));
        } catch (UnknownHostException ex) {
            LOGGER.error("AppStartError|" + ex.getLocalizedMessage(), ex);
        }

    }
}
