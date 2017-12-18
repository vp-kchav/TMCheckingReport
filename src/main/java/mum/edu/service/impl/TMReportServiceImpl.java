/*
 * Created on Dec 15, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.TMReportDao;
import mum.edu.domain.TMCheckingReport;
import mum.edu.service.TMReportService;

public class TMReportServiceImpl implements TMReportService{
    
    TMReportDao reportDao;

    @Transactional
    public TMCheckingReport save(TMCheckingReport report) {
        return reportDao.save(report);
    }

    public List<TMCheckingReport> getAll() {
        return reportDao.getAll();
    }
    
    @Transactional
    public TMCheckingReport update(TMCheckingReport report) {
        return reportDao.update(report);
    }

    @Transactional
    public List<TMCheckingReport> getByStudentId(String studentId){
       return reportDao.getByStudentId(studentId);
    }
    
    public List<TMCheckingReport> getPedingList() {
        return reportDao.getPedingList();
    }
    
    @Override
    @Transactional
    public TMCheckingReport getById(Long id) {
        return reportDao.getById(id);
    }
    
    public TMReportServiceImpl() {
    }

    public TMReportDao getReportDao() {
        return reportDao;
    }

    
    public void setReportDao(TMReportDao reportDao) {
        this.reportDao = reportDao;
    }

}
