package com.example.demo8.controller;

import com.example.demo8.entity.User;
import com.example.demo8.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/log_in")
    public String login(){
        return "loginPage";
    }
    @GetMapping("/sign_up")
    public String signUp(){
        return "signupPage";
    }
    @GetMapping("/home")
    public String home(){
        return "userHomepage";
    }
    @GetMapping("/profile")
    public String profile(){
        return "userProfilepage";
    }
    @GetMapping("/reset_password")
    public String resetPassword(){
        return "resetPassword";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession httpSession){
//        System.out.println(user);
        User user1 = userService.saveUser(user);
        if(user1!=null){
            httpSession.setAttribute("msg","Registeration Successful");
        }
        else{
            httpSession.setAttribute("msg","Something Went Wrong on Server");
        }
        return "redirect:/sign_up" ;
    }

}
