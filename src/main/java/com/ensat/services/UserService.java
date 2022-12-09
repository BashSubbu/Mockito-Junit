package com.ensat.services;

import com.ensat.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUsers(User user);
    void deleteUser(Integer id);
}
