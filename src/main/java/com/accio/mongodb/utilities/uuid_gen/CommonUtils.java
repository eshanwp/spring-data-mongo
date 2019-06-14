package com.accio.mongodb.utilities.uuid_gen;
/**
 * @author Esh
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;


public class CommonUtils {

    /**
     * @des generated UUID as a String to identify request processing flow
     * @return String.
     */
    public static String getUniqueId() {
        try {
            return String.valueOf(new SecureRandom(SecureRandom.getInstance("SHA1PRNG").generateSeed(10)).nextLong());
        } catch (NoSuchAlgorithmException ex) {
            return UUID.randomUUID().toString();
        }
    }

}
