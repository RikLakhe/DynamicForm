/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.controller;

import edu.lfa.df.dao.FormFieldDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value="/admin/dashboard")
public class DashboardController {
    
    @Autowired
    private FormFieldDAO formfieldDAO; 
    private Object model;
    
    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(){
        return "dashboard/dashmain";
    } 
    
    @RequestMapping(value="/addfield",method = RequestMethod.GET)
    public String addfield(){
        return "dashboard/addfield";
    }
    
    
    @RequestMapping(value="/newform",method = RequestMethod.GET)
    public String createform(Model model){
        model.addAttribute("FormFields",formfieldDAO.getAll());
        return "dashboard/newform";
    }
    
    
    @RequestMapping(value="/save",method = RequestMethod.GET)
    public String responses(){
        return "redirect:/dashboard";
    }
}
