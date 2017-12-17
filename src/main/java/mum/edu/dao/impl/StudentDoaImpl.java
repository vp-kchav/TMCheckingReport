package mum.edu.dao.impl;

import mum.edu.dao.StudentDao;
import mum.edu.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDoaImpl implements StudentDao {

    SessionFactory sessionFactory;


    @Override
    @Transactional
    public long save(Student student) {
        return (long) sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
    }

    @Override
    public Student update(Student student) {
        return (Student) sessionFactory.getCurrentSession().merge(student);
    }

    @Override
    public Student get(long id) {
        return (Student)sessionFactory.getCurrentSession().get(Student.class,id);
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
