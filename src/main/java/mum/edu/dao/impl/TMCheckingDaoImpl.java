/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import mum.edu.dao.TMCheckingDao;
import mum.edu.domain.TMChecking;

public class TMCheckingDaoImpl implements TMCheckingDao{
    
    SessionFactory sessionFactory;

    public TMChecking save(TMChecking report) {
        return (TMChecking)sessionFactory.getCurrentSession().save(report);
    }

    @SuppressWarnings("unchecked")
    public List<TMChecking> getAll() {
        List<TMChecking> list = new ArrayList<TMChecking>();
        list = sessionFactory.getCurrentSession().createCriteria(TMChecking.class).list();
        return list;
    }

    public TMChecking update(TMChecking report) {
        return (TMChecking) sessionFactory.getCurrentSession().merge(report);
    }

    public TMCheckingDaoImpl() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
