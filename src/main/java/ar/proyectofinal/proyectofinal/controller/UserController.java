package ar.proyectofinal.proyectofinal.controller;

import ar.proyectofinal.proyectofinal.model.User;
import ar.proyectofinal.proyectofinal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("users", userService.getUsers());
        return "users/index";
    }

}
