package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private UserService userService;


	@Autowired
	public void setUserService(UserService userService) {this.userService = userService;}



	@GetMapping(value = "/")
	public String allUsers(ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	@GetMapping(value = "/create")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "createUser";
	}

	@PostMapping(value = "/create")
	public String createUser(@ModelAttribute("user") User user) {
		userService.create(user);
		return "redirect:/";
	}
	@GetMapping(value = "/update/{id}")
	public String updateUser(ModelMap model, @PathVariable("id") Long id) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "updateUser";
	}

	@PostMapping(value = "/update")
	public String edit(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deleteUserById(@RequestParam("id") Long id) {
		userService.remove(id);
		return "redirect:/";
	}
}