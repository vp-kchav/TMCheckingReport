/*
 * Created on Dec 15, 2017
 */
package mum.edu.dao;

import java.util.List;

import mum.edu.domain.TMCheckingReport;

public interface TMReportDao {
    
    TMCheckingReport save(TMCheckingReport report);
    
    List<TMCheckingReport> getAll();
    
    TMCheckingReport update(TMCheckingReport report);
}
