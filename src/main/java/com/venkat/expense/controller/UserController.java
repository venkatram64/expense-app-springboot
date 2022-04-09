package com.venkat.expense.controller;

import com.venkat.expense.model.User;
import com.venkat.expense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping("/")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public long delete(@PathVariable String id){
        return userService.delete(id);
    }
}
