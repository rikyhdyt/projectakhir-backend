package com.bcafinace.projectakhir.service;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 20/01/2023
@Last Modified 20/01/2023 09:52
Version 1.0
*/

import com.bcafinace.projectakhir.models.User;
import com.bcafinace.projectakhir.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public void saveUser(User user) throws Exception{
        userRepo.save(user);
    }

}
