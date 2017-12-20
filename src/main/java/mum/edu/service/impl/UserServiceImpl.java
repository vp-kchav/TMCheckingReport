/*
 * Created on Dec 15, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.UserDao;
import mum.edu.domain.User;
import mum.edu.service.UserService;

public class UserServiceImpl implements UserService{
    
    UserDao userDao;

    @Transactional
    public long save(User user) {
        return userDao.save(user);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public User update(User report) {
        return userDao.update(report);
    }
    
    @Transactional
    public User findById(String id) {
        return userDao.findById(id);
    }

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
