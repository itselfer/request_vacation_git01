package com.example.itselfer1;

import com.example.itselfer1.Service.UserService;
import com.example.itselfer1.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class MainController {
    @Autowired
    private UserService userService;

    @PostMapping("/index")
    @ResponseBody
    public String saveUser(UserDto userDto) {
        userService.savePost(userDto);

        return "/index.html";
    }

    @PostMapping("/")
    @ResponseBody
    public String updateUser(UserDto userDto) {
        userService.updatePost(userDto);

        return "";
    }

    @GetMapping("/index_admin")
    public String index_admin() {
        return "/index_admin.html";
    }

    @GetMapping("/vacation")
    public String vacation() {
        return "/vacation.html";
    }

}
