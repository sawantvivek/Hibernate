package org.vivek.springexample.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vivek.springexample.model.Circle;

@Repository
public class HibernateImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int getcountCircle(){
		String hql = "SELECT COUNT(*) FROM CIRCLE";
		Query query =  getSessionFactory().openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}
	
	
	public void insertCircle(Circle circle){
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();
		session.save(circle);
		session.getTransaction().commit();
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
