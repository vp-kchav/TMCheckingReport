package mum.edu.dao.impl;

import mum.edu.dao.StudentDao;
import mum.edu.domain.Student;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDoaImpl implements StudentDao {

    SessionFactory sessionFactory;


    @Override
    public Student save(Student student) {
        return (Student) sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
    }

    @Override
    public Student update(Student student) {
        return (Student) sessionFactory.getCurrentSession().merge(student);
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
