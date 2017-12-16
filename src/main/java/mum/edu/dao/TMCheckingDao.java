/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao;

import java.util.List;

import mum.edu.domain.TMChecking;

public interface TMCheckingDao {
    
    TMChecking save(TMChecking report);
    
    List<TMChecking> getAll();
    
    TMChecking update(TMChecking report);
}
