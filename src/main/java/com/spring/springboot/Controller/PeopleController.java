package com.spring.springboot.Controller;

import com.spring.springboot.Model.User;
import com.spring.springboot.UserDAO.UserDAOImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeopleController {
    private final UserDAOImpl userDAOImpl;

    public PeopleController(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }


    @GetMapping(value = "users")
    public String allUsers(Model model) {
        model.addAttribute("users", userDAOImpl.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "users")
    public String addUser(@ModelAttribute("user") User user) {
        userDAOImpl.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        User user = userDAOImpl.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userDAOImpl.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userDAOImpl.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, Model modelMap) {
        modelMap.addAttribute("user", userDAOImpl.getUserById(id));
        return "show";
    }

}