package com.javi.controller;

import com.javi.entity.User;
import com.javi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javi/user")
public class UserController extends AbstractController<User, Long> {

    @Autowired
    private UserService userService;

    public UserController() {
        super.setService(userService);
    }

    @RequestMapping(value = "/findByEmail", method = RequestMethod.GET, produces = "application/json")
    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }
}
