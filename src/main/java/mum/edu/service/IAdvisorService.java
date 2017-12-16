package mum.edu.service;

import java.util.List;

import mum.edu.domain.Advisor;

public interface IAdvisorService {
	public int addAdvisor(Advisor advisor);
	public void deleteAdvisor(int id);
	public void updateAdvisor(int id,Advisor advisor);
	public Advisor getAdvisor(int id);
    public List<Advisor> getAllAdvisor();
    public List<TMReportService> getStudentTMRport(int studentid);
    public List<TMReportService> getAllStudentTMReport();
}
