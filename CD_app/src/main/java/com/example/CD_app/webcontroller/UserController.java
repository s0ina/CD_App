package com.example.CD_app.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.CD_app.domain.UserRepository;

@Controller
public class UserController {
	@Autowired
    private UserRepository repository; 
	
	
	 @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	
    }    
    
