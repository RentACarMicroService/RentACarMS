package com.appsdeveloperblog.rentalapp.api.users.controllers;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserService userService;
    private Environment environment;


    @Autowired
    public UsersController(UserService userService, Environment environment) {
        super();
        this.userService = userService;
        this.environment = environment;
    }

    @GetMapping("status/check")
    public String status() {
        return "working on : " + environment.getProperty("local.server.port");
    }

}
