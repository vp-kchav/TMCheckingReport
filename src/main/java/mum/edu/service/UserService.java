/*
 * Created on Dec 15, 2017
 */
package mum.edu.service;

import java.util.List;

import mum.edu.domain.User;

public interface UserService {

    User save(User user);
    
    List<User> getAll();
    
    User update(User user);

}
