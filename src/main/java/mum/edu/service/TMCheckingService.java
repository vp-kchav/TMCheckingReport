/*
 * Created on Dec 15, 2017
 */
package mum.edu.service;

import java.util.List;

import mum.edu.domain.TMChecking;

public interface TMCheckingService {

    TMChecking save(TMChecking report);
    
    List<TMChecking> getAll();
    
    TMChecking update(TMChecking report);

}
