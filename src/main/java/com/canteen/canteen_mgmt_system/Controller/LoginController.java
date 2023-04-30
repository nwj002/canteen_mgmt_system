package com.canteen.canteen_mgmt_system.Controller;

import com.canteen.canteen_mgmt_system.entity.Department;
import com.canteen.canteen_mgmt_system.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }



}
