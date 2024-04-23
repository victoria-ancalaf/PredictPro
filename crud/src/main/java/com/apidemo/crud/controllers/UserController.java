package com.apidemo.crud.controllers;

import com.apidemo.crud.models.UserModel;
import com.apidemo.crud.repositories.IUserRepository;
import com.apidemo.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/userDemo")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUSerById(@RequestBody UserModel request,@PathVariable("id") Long id){
        return this.userService.updateUSerById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
       boolean ok = this.userService.deleteUser(id);

        if (ok) {
            String s = ok +" User with id " + id + " deleted";
            return s;
        } else {
            return "Error: user with id " + id + " could not be deleted";
        }
    }

}
