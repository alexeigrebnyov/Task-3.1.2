package web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping(value = {"/", "/users"})
    public String getUser(ModelMap model) {
        User thisUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("users", userDetails);
        model.addAttribute("thisUser", thisUser);
        return "users";
    }
}
