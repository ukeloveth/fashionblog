package com.loveth.fashionblog.services.serviceImpl;

import com.loveth.fashionblog.dto.RegistrationDto;
import com.loveth.fashionblog.enums.Role;
import com.loveth.fashionblog.dto.UserDto;
import com.loveth.fashionblog.exception.InvalidRequestException;
import com.loveth.fashionblog.exception.UserAlreadyExistException;
import com.loveth.fashionblog.http.HttpResponseEntity;
import com.loveth.fashionblog.models.User;
import com.loveth.fashionblog.repository.UserRepository;
import com.loveth.fashionblog.services.UserServices;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserServices {

    private UserRepository userRepo;
    private  long userId;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public HttpResponseEntity createUser(UserDto userDto) {
        //check if the user exist
        Optional<User> existingUser = userRepo.findByEmail(userDto.getEmail());

        if(existingUser.isPresent()) {
            throw new UserAlreadyExistException("User already exist with email "+userDto.getEmail());
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.valueOf(userDto.getRole()));
        userRepo.save(user);


        return new HttpResponseEntity().setStatus("Success").setMessage("Account created succesfully").setData(user);
    }
    //  working
    @Override
    public List<User> getAllUsers() {
        return  userRepo.findAll();
    }



    @Override
    public User loginUser(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email,password);
        if(user == null){
            throw new InvalidRequestStateException("invalid email /password");
        }

        return user;
    }

    @Override
    public User editUserProfile(long id, RegistrationDto registrationDto) throws InvalidRequestException {
        User user = userRepo.getById(id);

        if(user == null){
            throw new InvalidRequestException("User not found");
        }
        user.setRole(Role.valueOf(registrationDto.getRole()));
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        userRepo.save(user);
        return user;
    }



    @Override
    public void deleteUserAccount(User user) throws InterruptedException, InvalidRequestException {
        if(user == null){
            throw new InvalidRequestException("User not found");

        }
        userRepo.delete(user);

    }


}
