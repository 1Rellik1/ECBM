package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("/login")
    public String afterLogin() {
        return "login";
    }

    @GetMapping("/login-error")
    public String errorLogin() {
        return "loginError";
    }

}
