package mum.edu.dao;


import java.util.List;

import mum.edu.domain.Advisor;

public interface IAdvisorDao {
	
	public long addAdvisor(Advisor advisor);
	public void updateAdvisor(Advisor advisor, long id);
	public Advisor getAdvisor(long id);
	public List<Advisor> getAdvisors();
	public void deleteAdvisor(long id);

}
