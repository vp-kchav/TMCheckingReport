package mum.edu.dao;


import java.util.List;

import mum.edu.domain.Advisor;

public interface IAdvisorDao {
	
	public int addAdvisor(Advisor advisor);
	public void updateAdvisor(Advisor advisor, int id);
	public Advisor getAdvisor(int id);
	public List<Advisor> getAdvisors();
	public void deleteAdvisor(int id);

}
