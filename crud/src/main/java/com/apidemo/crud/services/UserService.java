package com.apidemo.crud.services;

import com.apidemo.crud.models.UserModel;
import com.apidemo.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList <UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateUSerById(UserModel request, Long id ){
        UserModel user = userRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return  user;

    }

    public Boolean deleteUser(Long id){

        try{
            userRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;

        }
    }
}
