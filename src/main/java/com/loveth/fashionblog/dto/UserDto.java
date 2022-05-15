package com.loveth.fashionblog.dto;


import lombok.Data;


@Data
public class UserDto {

    private String username;

    private  String email;

    private String role;

    private String password;
}
