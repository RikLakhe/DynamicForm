/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.UserDAO;
import edu.lfa.df.entity.FormResponses;
import edu.lfa.df.entity.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAKHE
 */
@Repository(value="userDAO")
public class UserDAOImpl implements  UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(User t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        session.saveOrUpdate(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public User getById(int id) {
        session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> user = null;
        session = sessionFactory.openSession();
        user = session.createQuery("SELECT c FROM User c").list();
        session.close();
        return user;
    }
    
}
