/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.FormOptionDAO;
import edu.lfa.df.entity.FormOption;
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
@Repository(value = "formoptionDAO")
public class FormOptionDAOImpl implements FormOptionDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(FormOption t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(FormOption t) {
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
        FormOption formoption = (FormOption) session.get(FormOption.class, id);
        if (formoption != null) {
            session.delete(formoption);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public FormOption getById(int id) {
        session = sessionFactory.openSession();
        FormOption formoption = (FormOption) session.get(FormOption.class, id);
        session.close();
        return formoption;
    }

    @Override
    public List<FormOption> getAll() {
        List<FormOption> formoption = null;
        session = sessionFactory.openSession();
        formoption = session.createQuery("SELECT c FROM FormOption c").list();
        session.close();
        return formoption;
    }
    

   
}
