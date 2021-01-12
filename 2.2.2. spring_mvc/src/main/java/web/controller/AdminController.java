package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {this.userService = userService;}


	@GetMapping(value = "/admin")
	public String getAllUsers(ModelMap model) {
		User thisUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("thisUser", thisUser);
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("roles", userService.getRole());
		model.addAttribute("newUser", new User());
		return "admin";
	}


	@PostMapping(value = "/createUser")
	public String createUser(@ModelAttribute("user") User user) {
		userService.create(user);
		return "redirect:/admin";
	}
	@PostMapping(value = "/updateUser/{id}")
	public String updateUser(ModelMap model, @PathVariable("id") Long id) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("roles", userService.getRole());
		return  "redirect:/admin";
	}

	@PostMapping(value = "/updateUser")
	public String update(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/admin";
	}
	@PostMapping("/delete")
	public String deleteUserById(@RequestParam(value = "id", required = false) Long id) {
		userService.remove(id);
		return "redirect:/admin";
	}
}