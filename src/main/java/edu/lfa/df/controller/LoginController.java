/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.controller;

import edu.lfa.df.service.LoginService;
import edu.lfa.df.system.LoginForm;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public LoginService loginService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/sucess", method = RequestMethod.POST)
    public String processForm(@Valid LoginForm loginForm, BindingResult result,
            Map model) {
//        if (result.hasErrors()) {
//            return "redirect:/login";
//        }
        String userName = "uUsername";
        String password = "uPassword";
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        loginForm = (LoginForm) model.get("loginForm");
        if (loginForm.getUserName().equals(userName)
                && loginForm.getPassword().equals(password)) {
            return "redirect:/admin/dashboard";
        }
        model.put("loginForm", loginForm);
        return "redirect:/admin/dashboard";

        
//         String userName = "UserName";
//         String password = "password";
//         loginForm = (LoginForm) model.get("loginForm");
//         if (!loginForm.getUserName().equals(userName)
//         || !loginForm.getPassword().equals(password)) {
//         return "redirect:/admin/dashboard";
//         }
         
////        boolean userExists = loginService.checkLogin(loginForm.getUserName(),
//                loginForm.getPassword());
//        if (userExists) {
//            model.put("loginForm", loginForm);
//            return "redirect:/admin/dashboard";
//        } else {
//            result.rejectValue("UserName", "invaliduser");
//            return "redirect:/login";
//        }
    }
}
