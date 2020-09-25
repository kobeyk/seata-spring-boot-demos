package com.appleyk.common.response;

import java.io.Serializable;


public class BaseResponse implements Serializable {

    public BaseResponse(){}

    private int status = 200;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
