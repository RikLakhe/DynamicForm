/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.service.impl;

import edu.lfa.df.dao.LoginDAO;
import edu.lfa.df.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LAKHE
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public boolean checkLogin(String userName, String userPassword) {
        System.out.println("In Service class...Check Login");
        return loginDAO.checkLogin(userName, userPassword);
    }
}
