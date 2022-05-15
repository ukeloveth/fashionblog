package com.loveth.fashionblog.http;

import lombok.*;

public class HttpResponseEntity {
    private String status;
    private String message;
    private String data;

    public HttpResponseEntity(final String status) {
        this.status = status;
    }

    public HttpResponseEntity(final String status, final String message, final String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpResponseEntity setStatus(final String status) {
        this.status = status;
        return this;
    }

    public HttpResponseEntity setMessage(final String message) {
        this.message = message;
        return this;
    }

    public HttpResponseEntity setData(final String data) {
        this.data = data;
        return this;

    }


    public static HttpResponseEntity build(){
        return new HttpResponseEntity(status, message, data);
    }

}
