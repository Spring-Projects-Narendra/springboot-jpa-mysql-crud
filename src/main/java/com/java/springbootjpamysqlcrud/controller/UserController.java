package com.java.springbootjpamysqlcrud.controller;

import com.java.springbootjpamysqlcrud.exception.ResourceNotFoundException;
import com.java.springbootjpamysqlcrud.model.User;
import com.java.springbootjpamysqlcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        System.out.println(allUsers);
        return allUsers;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer userid){
        Optional<User> userOptional = userRepository.findById(userid);

        return userOptional.isPresent() ? userOptional.get() : null;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        System.out.println("saving user");
        userRepository.save(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id){
        System.out.println("inside delete user");
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", id));
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
