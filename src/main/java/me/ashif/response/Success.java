package me.ashif.response;

import org.springframework.stereotype.Component;

/**
 * Created by asif on 31/1/17.
 */

@Component
public class Success {

    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
