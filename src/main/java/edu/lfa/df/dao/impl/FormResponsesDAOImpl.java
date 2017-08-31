/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.FormResponsesDAO;
import edu.lfa.df.entity.FormOption;
import edu.lfa.df.entity.FormResponses;
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
@Repository(value="formresponsesDAO")
public class FormResponsesDAOImpl implements FormResponsesDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(FormResponses t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(FormResponses t) {
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
        FormResponses formresponses = (FormResponses) session.get(FormResponses.class, id);
        if (formresponses != null) {
            session.delete(formresponses);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public FormResponses getById(int id) {
        session = sessionFactory.openSession();
        FormResponses formresponses = (FormResponses) session.get(FormResponses.class, id);
        session.close();
        return formresponses;
    }

    @Override
    public List<FormResponses> getAll() {
        List<FormResponses> formresponses = null;
        session = sessionFactory.openSession();
        formresponses = session.createQuery("SELECT c FROM FormResponses c").list();
        session.close();
        return formresponses;
    }
    
}
