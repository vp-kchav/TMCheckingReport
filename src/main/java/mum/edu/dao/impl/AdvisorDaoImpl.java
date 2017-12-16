package mum.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.dao.IAdvisorDao;
import mum.edu.domain.Advisor;

//@Repository
public class AdvisorDaoImpl implements IAdvisorDao {
	
	//@Autowired
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public long addAdvisor(Advisor advisor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(advisor);
		return advisor.getId();
	}

	@Override
	public void updateAdvisor(Advisor advisor, long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Advisor advisorUpdated=(Advisor) session.byId(Advisor.class).load(id);
		advisorUpdated.setFirstname(advisor.getFirstname());
		advisorUpdated.setLastname(advisor.getLastname());
		advisorUpdated.setAdvisorid(advisor.getAdvisorid());
		advisorUpdated.setAddress(advisor.getAddress());
		advisorUpdated.setGender(advisor.getGender());
		session.flush();
	}

	@Override
	public Advisor getAdvisor(long id) {
		// TODO Auto-generated method stub
		return (Advisor) sessionFactory.getCurrentSession().get(Advisor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advisor> getAdvisors() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Advisor> advisorAll=new ArrayList<Advisor>();
		advisorAll=session.createCriteria(Advisor.class).list();
		return advisorAll;
		
	}

	@Override
	public void deleteAdvisor(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Advisor advisor=(Advisor) session.get(Advisor.class, id);
		session.delete(advisor);
	}

	

		

}
