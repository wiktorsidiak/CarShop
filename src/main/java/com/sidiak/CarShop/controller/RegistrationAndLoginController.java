package com.sidiak.CarShop.controller;

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

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationAndLoginController {
	@Autowired
	UserServiсe userServiсe;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute("user") @Valid User user, Map<String, Object> model) {
		User userFromDB = userRepo.findByUsername(user.getUsername());
		if (userFromDB != null) {
			model.put("message", "user exists! Please Log In");
			return "redirect:/login";
		} else {
			userServiсe.saveUser(user);;
			return "redirect:/registration?success";
		}
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}
}
