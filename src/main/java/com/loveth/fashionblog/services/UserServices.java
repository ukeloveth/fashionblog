package com.loveth.fashionblog.services;

import com.loveth.fashionblog.dto.RegistrationDto;
import com.loveth.fashionblog.dto.UserDto;
import com.loveth.fashionblog.exception.InvalidRequestException;
import com.loveth.fashionblog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserServices {
    User createUser(UserDto user);

    // not working yet
    List<User> getAllUsers();

    User loginUser(String email, String password);

    User editUserProfile(long id, RegistrationDto registrationDto) throws InvalidRequestException;

    void deleteUserAccount(User user) throws InterruptedException, InvalidRequestException;


}
