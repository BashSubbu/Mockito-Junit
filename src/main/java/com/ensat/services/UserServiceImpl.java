package com.ensat.services;

import com.ensat.entities.User;
import com.ensat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User saveUsers(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {

    }
}
