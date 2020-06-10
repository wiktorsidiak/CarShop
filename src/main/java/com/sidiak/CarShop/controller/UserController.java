package com.sidiak.CarShop.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class UserController implements WebMvcConfigurer {
    @PostMapping("users")
    @RequestMapping(value = "username")





}
