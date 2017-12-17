/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.UserDao;
import mum.edu.domain.User;

public class UserDaoImpl implements UserDao{
    
    SessionFactory sessionFactory;

    @Transactional
    public long save(User user) {
        return (long) sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        list = sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return list;
    }

    @Transactional    
    public User update(User user) {
        return (User) sessionFactory.getCurrentSession().merge(user);
    }

    public UserDaoImpl() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
