package com.sidiak.CarShop.controller;

import javax.validation.Valid;

import java.util.Map;

import com.sidiak.CarShop.model.User;
import com.sidiak.CarShop.repository.UserRepo;
import com.sidiak.CarShop.service.User.UserServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationAndLoginController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserServiсe userServiсe;

    @Autowired
    PasswordEncoder passwordEncoder;



    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }
        @PostMapping("/registration")
        public String addUser(@ModelAttribute("user") @Valid User user, Map<String, Object> model) {
            User userFromDB = userRepo.findByUsername(user.getUsername());
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            if (userFromDB != null) {
                model.put("message", "user exists! Please Log In");

                return "redirect:/login";
            } else {
                User createUser = new User();
                userServiсe.saveUser(createUser);
                user.setUsername(user.getUsername());
                user.setPassword(encodedPassword);
                userRepo.save(user);

                return "redirect:/registration?success";
            }
        }

            @GetMapping("/login")
                 public String login(Model model, String error, String logout){
            if (error != null)
                model.addAttribute("error", "Your username and password is invalid.");

            if (logout != null)
                model.addAttribute("message", "You have been logged out successfully.");

            return "login";
        }
}
