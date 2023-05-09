package com.canteen.canteen_mgmt_system.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/logout")
    public String logoutMethod(Authentication authentication){
        if(authentication.isAuthenticated()){
            SecurityContextHolder.clearContext();
        }
        return "redirect:/login";
    }



}
