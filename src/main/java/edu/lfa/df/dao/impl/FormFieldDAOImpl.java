/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.FormFieldDAO;
import edu.lfa.df.entity.FormFields;
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
@Repository(value = "formfieldDAO")
public class FormFieldDAOImpl implements FormFieldDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(FormFields t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(FormFields t) {
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
        FormFields form = (FormFields) session.get(FormFields.class, id);
        if (form != null) {
            session.delete(form);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public FormFields getById(int id) {
        session = sessionFactory.openSession();
        FormFields form = (FormFields) session.get(FormFields.class, id);
        session.close();
        return form;
    }

    @Override
    public List<FormFields> getAll() {
        List<FormFields> form = null;
        session = sessionFactory.openSession();
        form = session.createQuery("SELECT c FROM FormFields c").list();
        session.close();
        return form;
    }
    
}
