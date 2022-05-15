package com.loveth.fashionblog.exception;

public class UserNotAuthorizedException extends RuntimeException {
    public UserNotAuthorizedException(String s) {
        super(s);
    }
}
