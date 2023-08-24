package com.example.demo.user.controller;

import java.util.Date;

public class ExceptionResponse {
    Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public ExceptionResponse(String message) {
        this.time = new Date();
        this.message = message;
    }
}
