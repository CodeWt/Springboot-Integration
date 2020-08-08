package com.example.demo.interfaceframe.controller;

import com.example.demo.interfaceframe.ResultVO;
import com.example.demo.interfaceframe.User;
import com.example.demo.interfaceframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        // 注意哦，这里是直接返回的User类型，并没有用ResultVO进行包装
        return user;
    }

    @GetMapping("/getUserN")
    public ResultVO getUserN() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        // 注意哦，这里是直接返回的User类型，并没有用ResultVO进行包装
        return new ResultVO(user);
    }
}
