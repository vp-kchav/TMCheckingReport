/*
 * Created on Dec 15, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import mum.edu.dao.UserDao;
import mum.edu.domain.User;
import mum.edu.service.UserService;

public class UserServiceImpl implements UserService{
    
    UserDao userDao;

    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User update(User report) {
        return userDao.update(report);
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
