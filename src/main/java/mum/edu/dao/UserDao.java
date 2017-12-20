/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao;

import java.util.List;

import mum.edu.domain.User;

public interface UserDao {
    
    long save(User user);
    
    List<User> getAll();
    
    User update(User user);
    
    User findById(String id);
}
