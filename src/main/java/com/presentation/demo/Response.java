package com.presentation.demo;

import java.io.Serializable;

public class Response implements Serializable {

    private  int code;
    private String message;

    public Response() {

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
