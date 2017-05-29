/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.FormDAO;
import edu.lfa.df.entity.Form;
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
@Repository(value = "formDAO")
public class FormDAOImpl implements FormDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(Form t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Form t) {
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
        Form form = (Form) session.get(Form.class, id);
        if (form != null) {
            session.delete(form);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Form getById(int id) {
        session = sessionFactory.openSession();
        Form form = (Form) session.get(Form.class, id);
        session.close();
        return form;
    }

    @Override
    public List<Form> getAll() {
        List<Form> form = null;
        session = sessionFactory.openSession();
        form = session.createQuery("SELECT c FROM Form c").list();
        session.close();
        return form;
    }
    
}
