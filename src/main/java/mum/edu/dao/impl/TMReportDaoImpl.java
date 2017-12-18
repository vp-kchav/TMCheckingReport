/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.TMReportDao;
import mum.edu.domain.TMCheckingReport;

public class TMReportDaoImpl implements TMReportDao{
    
    SessionFactory sessionFactory;

    @Transactional
    public TMCheckingReport getById(Long id) {
        return (TMCheckingReport) sessionFactory.getCurrentSession().get(TMCheckingReport.class,id);
    }
    
    @Transactional
    public TMCheckingReport save(TMCheckingReport report) {
        return (TMCheckingReport)sessionFactory.getCurrentSession().save(report);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<TMCheckingReport> getAll() {
        List<TMCheckingReport> list = new ArrayList<TMCheckingReport>();
        list = sessionFactory.getCurrentSession().createCriteria(TMCheckingReport.class).list();
        return list;
    }

    @Transactional
    public TMCheckingReport update(TMCheckingReport report) {
        return (TMCheckingReport) sessionFactory.getCurrentSession().merge(report);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<TMCheckingReport> getByStudentId(String studentId){
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT s.tmCheckings FROM Student s where studentId = :studentId");
        query.setParameter("studentId", studentId);
        return (List<TMCheckingReport>)query.list();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<TMCheckingReport> getPedingList(){
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT r FROM TMCheckingReport r where r.status = 'PENDING'");
        return (List<TMCheckingReport>) query.list();
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
