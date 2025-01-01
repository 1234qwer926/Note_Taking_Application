package com.Pavan.NoteTaking.Controller;

import com.Pavan.NoteTaking.Model.User;
import com.Pavan.NoteTaking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }
}
