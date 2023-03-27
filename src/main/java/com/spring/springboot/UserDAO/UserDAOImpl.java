package com.spring.springboot.UserDAO;

import com.spring.springboot.Model.User;
import com.spring.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAOImpl {
    private final UserRepository userRepository;

    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    public void  editUser(User user) {
    userRepository.save(user);
    }


    public User getUserById(Long id) {

        return userRepository.getOne(id);
    }


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
