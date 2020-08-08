package com.example.demo.interfaceframe.service;

import com.example.demo.interfaceframe.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String addUser(User user) {

        //专注于业务逻辑

        return "success in service";
    }
}
