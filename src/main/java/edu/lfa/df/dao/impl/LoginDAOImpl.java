/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.LoginDAO;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAKHE
 */
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public boolean checkLogin(String userName, String userPassword) {
        System.out.println("In Check login");
        Session session = sessionFactory.openSession();
        boolean userFound = false;
        
        String SQL_QUERY = "SELECT o from User as o where o.uUsername=:username and o.uPassword=:password";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("username", userName);
        query.setParameter("password", userPassword);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }

        session.close();
        return userFound;
    }
}
