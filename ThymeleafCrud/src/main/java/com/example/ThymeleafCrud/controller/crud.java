package com.example.ThymeleafCrud.controller;

import com.example.ThymeleafCrud.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class crud {

    private final List<Users> userList = new ArrayList<>();

    // Show list
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userList);
        return "list";
    }

    // Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new Users());
        return "add";
    }

    // Save new user
    @PostMapping("/save")
    public String saveUser(@ModelAttribute Users user) {
        userList.add(user);
        return "redirect:/users";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        for (Users u : userList) {
            if (u.getId() == id) {
                model.addAttribute("user", u);
                return "edit";
            }
        }
        return "redirect:/users";
    }

    // Update user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute Users updatedUser) {
        for (Users u : userList) {
            if (u.getId() == id) {
                u.setName(updatedUser.getName());
                break;
            }
        }
        return "redirect:/users";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userList.removeIf(u -> u.getId() == id);
        return "redirect:/users";
    }
}
