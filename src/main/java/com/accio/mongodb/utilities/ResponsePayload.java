package com.accio.mongodb.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author Esh
 */
@JsonPropertyOrder({ "code", "msg", "data" })
public class ResponsePayload {

    @JsonProperty("data")
    private HashMap data;

    @JsonProperty("code")
    private int code;

    @JsonProperty("msg")
    private String msg;

    public ResponsePayload(HashMap data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static class Builder {

        private HashMap data = new HashMap();
        private int code;
        private String msg;

        public Builder(HttpStatus httpStatus) {
            this.code = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }

        public Builder addPayloadAttr(String key, Object value) {
            this.data.put(key, value);
            return this;
        }

        public JSONObject build(){
            JSONObject response = new JSONObject();
            response.put("data", data);
            response.put("httpStatusCode", code);
            response.put("httpStatusMsg", msg);
            return response;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
