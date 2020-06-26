package com.sidiak.CarShop.controller;

import javax.validation.Valid;

import java.util.Map;

import com.sidiak.CarShop.dto.UserRegistrationDTO;
import com.sidiak.CarShop.model.User;
import com.sidiak.CarShop.repository.UserRepo;
import com.sidiak.CarShop.service.User.UserServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserServiсe userServiсe;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());


        return "registration";
    }
        @PostMapping("/registration")
        public String addUser(@Valid  User user, UserRegistrationDTO userRegistrationDTO, Map<String, Object> model){
            User userFromDB = userRepo.findByUsername(user.getUsername());
            if(userFromDB !=null){
                model.put("message", "user exists! Please Log In");

                return "redirect:/login";
            }else{
                userServiсe.saveUser(user);

                return "redirect:/registration?success";
            }
        }
}
