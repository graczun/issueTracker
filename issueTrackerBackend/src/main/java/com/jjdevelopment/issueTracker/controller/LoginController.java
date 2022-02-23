package com.jjdevelopment.issueTracker.controller;

import com.jjdevelopment.issueTracker.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //TODO: remove me after implementing JWT

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO user) {
        return true;
    }

}
