package ru.job4j.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.job4j.dream.model.User;
import ru.job4j.dream.service.UserService;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        return "fail";
    }

    @GetMapping("/formAddUser")
    public String newUser() {
        return "addUser";
    }

    @PostMapping("/registration")
    public String registration(RedirectAttributes redirectAttrs, @ModelAttribute User user) {
        Optional<User> regUser = Optional.ofNullable(userService.add(user));
        if (regUser.isEmpty()) {
            redirectAttrs.addAttribute("message", "Пользователь с такой почтой уже существует");
            return "redirect:/fail";
        }
        return "redirect:/success";
    }
}
