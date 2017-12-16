/*
 * Created on Dec 15, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import mum.edu.dao.TMCheckingDao;
import mum.edu.domain.TMChecking;
import mum.edu.service.TMCheckingService;

public class TMCheckingServiceImpl implements TMCheckingService{
    
    TMCheckingDao reportDao;

    public TMChecking save(TMChecking report) {
        return reportDao.save(report);
    }

    public List<TMChecking> getAll() {
        return reportDao.getAll();
    }

    public TMChecking update(TMChecking report) {
        return reportDao.update(report);
    }

    public TMCheckingServiceImpl() {
    }

    public TMCheckingDao getReportDao() {
        return reportDao;
    }

    
    public void setReportDao(TMCheckingDao reportDao) {
        this.reportDao = reportDao;
    }
}
