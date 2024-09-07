package com.example.demo8.service;

import com.example.demo8.entity.User;
import com.example.demo8.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create user
    public User saveUser(User user){
        User user1= userRepository.save(user);
        return user1;
    }
    //login user

    //remove session message
    public void removeSessionMessage(){
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
                .getRequest()
                .getSession();
        session.removeAttribute("msg");
    }

}
