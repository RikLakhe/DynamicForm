/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value="/dashboard")
public class DashboardController {
    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(){
        return "dashboard/dashmain";
    } 
    
    @RequestMapping(value="/addfield",method = RequestMethod.GET)
    public String addfield(){
        return "dashboard/addfield";
    }
    
    
    @RequestMapping(value="/newform",method = RequestMethod.GET)
    public String createform(){
        return "dashboard/newform";
    }
    
    
    @RequestMapping(value="/responses",method = RequestMethod.GET)
    public String responses(){
        return "dashboard/responses";
    }
}
