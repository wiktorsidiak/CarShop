package com.sidiak.CarShop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.sidiak.CarShop.dto.UserLoginFormDTO;
import com.sidiak.CarShop.model.User;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class LoginController {
        private RequestCache requestCache = new HttpSessionRequestCache();


        @RequestMapping("/authenticate")
        public String authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            boolean authenticate = request.authenticate(response);
            return authenticate ? "index" : null;
        }


        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserLoginFormDTO userLoginFormDTO,
                            BindingResult result) throws ServletException {
            try {
                request.login(userLoginFormDTO.getUsername(), userLoginFormDTO.getPassword());
                SavedRequest savedRequest = requestCache.getRequest(request, response);
                if (savedRequest != null) {
                    return "redirect:" + savedRequest.getRedirectUrl();
                } else {
                    return "redirect:/";
                }

            } catch (ServletException authenticationFailed) {
                result.rejectValue(null, "authentication failed");
                return "login";
            }
        }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String login(@ModelAttribute UserLoginFormDTO userLoginFormDTO) {
            return "login";
        }


        @RequestMapping("/logout")
        public String logout(HttpServletRequest request) throws ServletException {
            request.logout();
            return "redirect:/";
    }
}
