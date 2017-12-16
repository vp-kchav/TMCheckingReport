/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import mum.edu.dao.TMReportDao;
import mum.edu.domain.TMCheckingReport;

public class TMReportDaoImpl implements TMReportDao{
    
    SessionFactory sessionFactory;

    public TMCheckingReport save(TMCheckingReport report) {
        return (TMCheckingReport)sessionFactory.getCurrentSession().save(report);
    }

    @SuppressWarnings("unchecked")
    public List<TMCheckingReport> getAll() {
        List<TMCheckingReport> list = new ArrayList<TMCheckingReport>();
        list = sessionFactory.getCurrentSession().createCriteria(TMCheckingReport.class).list();
        return list;
    }

    public TMCheckingReport update(TMCheckingReport report) {
        return (TMCheckingReport) sessionFactory.getCurrentSession().merge(report);
    }

    public TMReportDaoImpl() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
