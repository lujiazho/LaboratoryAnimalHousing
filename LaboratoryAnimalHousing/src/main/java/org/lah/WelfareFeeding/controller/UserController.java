package org.lah.WelfareFeeding.controller;

import org.lah.Commons.domain.User;
import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    @UserAuthority(department = "*", position = "*")
    public User getCurrentUser(){
        User result = userService.getUser();
        // 虽然有权限验证，但不需要传输密码
        result.setPassword("");
        return result;
    }
}
