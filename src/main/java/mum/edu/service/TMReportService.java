/*
 * Created on Dec 15, 2017
 */
package mum.edu.service;

import java.util.List;

import mum.edu.domain.TMCheckingReport;

public interface TMReportService {

    TMCheckingReport save(TMCheckingReport report);
    
    List<TMCheckingReport> getAll();
    
    TMCheckingReport update(TMCheckingReport report);

}
