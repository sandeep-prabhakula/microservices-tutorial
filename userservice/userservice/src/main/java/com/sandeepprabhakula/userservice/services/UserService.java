package com.sandeepprabhakula.userservice.services;

import com.sandeepprabhakula.userservice.entities.Users;

import java.util.List;

public interface UserService {
    Users save(Users user);

    List<Users>getAllUsers();

    Users getUser(String uid);

}
