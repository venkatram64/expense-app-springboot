package com.venkat.expense.service;

import com.venkat.expense.model.User;
import com.venkat.expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public long delete(String id) {
        return userRepository.delete(id);
    }

    public long delete(User user) {
        return userRepository.delete(user);
    }
}
