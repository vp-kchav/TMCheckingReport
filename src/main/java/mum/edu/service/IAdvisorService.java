package mum.edu.service;

import java.util.List;

import mum.edu.domain.Advisor;

public interface IAdvisorService {
	public long addAdvisor(Advisor advisor);
	public void deleteAdvisor(long id);
	public void updateAdvisor(long id,Advisor advisor);
	public Advisor getAdvisor(long id);
    public List<Advisor> getAllAdvisor();
    public List<TMReportService> getStudentTMRport(int studentid);
    public List<TMReportService> getAllStudentTMReport();
}
