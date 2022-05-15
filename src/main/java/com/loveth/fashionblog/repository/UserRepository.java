package com.loveth.fashionblog.repository;

import com.loveth.fashionblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    // not working yet
    List<User> findAll();

    User findByEmailAndPassword(String email,String password);

//    User findByEmailOrUsernameOrPassword(String email, String username);

//    List<User> DeleteAccount(boolean status);
}
