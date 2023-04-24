package com.attendance.demo.web;

import com.attendance.demo.model.binding.RegisterBindingModel;
import com.attendance.demo.service.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

//    @GetMapping("/user/register")
//    public String getRegisterPage(Model model){
//        if(!model.containsAttribute("registerUser")){
//            model.addAttribute("registerUser");
//        }
//        return "register";
//    }
//
//    @PatchMapping("/user/register")
//    public String register(@ModelAttribute RegisterBindingModel registerBindingModel,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors() ||
//                !registerBindingModel.getConfirmPassword().equals(registerBindingModel.getPassword())){
//            redirectAttributes.addFlashAttribute("registerUser",registerBindingModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
//                    bindingResult);
//        }
//
//
//
//        this.userService.registerUser(registerBindingModel);
//
//        return "redirect:/add/course";
//    }

    @GetMapping("/user/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("user/login-error")
    public String login(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("badCredentials",true);
        return "redirect:/users/login";
    }


























}
