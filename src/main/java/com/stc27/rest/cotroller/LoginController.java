package com.stc27.rest.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "login";
    }
}
