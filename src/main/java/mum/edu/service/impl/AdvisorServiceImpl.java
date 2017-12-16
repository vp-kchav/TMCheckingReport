package mum.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.IAdvisorDao;
import mum.edu.domain.Advisor;
import mum.edu.service.IAdvisorService;
import mum.edu.service.TMReportService;

//@Service
@Transactional (readOnly=true)
public class AdvisorServiceImpl implements IAdvisorService{

	//@Autowired
	private IAdvisorDao advisorDao;
	
	@Transactional
	@Override
	public int addAdvisor(Advisor advisor) {
		// TODO Auto-generated method stub
		return advisorDao.addAdvisor(advisor);
	}

	@Transactional
	@Override
	public void deleteAdvisor(int id) {
		// TODO Auto-generated method stub
		advisorDao.deleteAdvisor(id);
	}

	@Transactional
	@Override
	public void updateAdvisor(int id, Advisor advisor) {
		// TODO Auto-generated method stub
		advisorDao.updateAdvisor(advisor, id);
		
	}

	@Override
	public Advisor getAdvisor(int id) {
		// TODO Auto-generated method stub
		return advisorDao.getAdvisor(id);
	}

	@Override
	public List<Advisor> getAllAdvisor() {
		// TODO Auto-generated method stub
		return advisorDao.getAdvisors();
	}

	@Override
	public List<TMReportService> getStudentTMRport(int studentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TMReportService> getAllStudentTMReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
