/*
 * Created on Dec 15, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import mum.edu.dao.TMReportDao;
import mum.edu.domain.TMCheckingReport;
import mum.edu.service.TMReportService;

public class TMReportServiceImpl implements TMReportService{
    
    TMReportDao reportDao;

    public TMCheckingReport save(TMCheckingReport report) {
        return reportDao.save(report);
    }

    public List<TMCheckingReport> getAll() {
        return reportDao.getAll();
    }

    public TMCheckingReport update(TMCheckingReport report) {
        return reportDao.update(report);
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
