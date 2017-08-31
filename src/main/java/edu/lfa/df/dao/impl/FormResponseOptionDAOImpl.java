/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao.impl;

import edu.lfa.df.dao.FormResponseOptionDAO;
import edu.lfa.df.entity.FormOption;
import edu.lfa.df.entity.FormResponseOptions;
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
@Repository(value="formresponseoptionDAO")
public class FormResponseOptionDAOImpl implements FormResponseOptionDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public boolean insert(FormResponseOptions t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(FormResponseOptions t) {
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
        FormResponseOptions formresponseoptions = (FormResponseOptions) session.get(FormResponseOptions.class, id);
        if (formresponseoptions != null) {
            session.delete(formresponseoptions);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public FormResponseOptions getById(int id) {
        session = sessionFactory.openSession();
        FormResponseOptions formresponseoptions = (FormResponseOptions) session.get(FormResponseOptions.class, id);
        session.close();
        return formresponseoptions;
    }

    @Override
    public List<FormResponseOptions> getAll() {
        List<FormResponseOptions> formresponseoptions = null;
        session = sessionFactory.openSession();
        formresponseoptions = session.createQuery("SELECT c FROM FormResponseOptions c").list();
        session.close();
        return formresponseoptions;
    }
    
}
