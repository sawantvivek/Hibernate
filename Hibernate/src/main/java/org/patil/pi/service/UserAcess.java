package org.patil.pi.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.patil.pi.bean.Address;
import org.patil.pi.bean.UserDetails;

public class UserAcess {

	public static void main(String[] args) {

		UserDetails details = new UserDetails();

		details.setFirstName("VIVEK SAWANT");

		Address address = new Address();
		address.setCity("MUMBAI");
		address.setPostalcode("400083");
		address.setState("MAHARASHTRA");
		address.setStreet("KANNAMWAR NAGAR 1");
		details.setHomeAddress(address);

		Address officeAddress = new Address();
		officeAddress.setCity("SUNNYVALE");
		officeAddress.setPostalcode("94083");
		officeAddress.setState("CALIFORNIA");
		officeAddress.setStreet("SONORA COURT");
		details.setOfficeAddress(officeAddress);
		
		
		details.getListOfAddress().add(address);
		details.getListOfAddress().add(officeAddress);
		

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(details);

		session.getTransaction().commit();
		session.close();

	}

}
