package mum.edu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.StudentDao;
import mum.edu.domain.Student;

public class StudentDoaImpl implements StudentDao {

    SessionFactory sessionFactory;

    @Override
    @Transactional
    public long save(Student student) {
        return (long) sessionFactory.getCurrentSession().save(student);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT Distinct s FROM Student s");
        return query.list();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return (Student) sessionFactory.getCurrentSession().merge(student);
    }

    @Override
    public Student get(long id) {
        return (Student)sessionFactory.getCurrentSession().get(Student.class,id);
    }
    
    @Override
    @Transactional
    public  Student getByStudentId(String studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT s FROM Student s where studentId = :studentId");
        query.setParameter("studentId", studentId);
        return (Student)query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Student> findByStudentId(String studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT s FROM Student s where studentId like :studentId");
        query.setParameter("studentId", "%"+studentId+"%");
        return query.list();
    }
    
    public StudentDoaImpl(){

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
