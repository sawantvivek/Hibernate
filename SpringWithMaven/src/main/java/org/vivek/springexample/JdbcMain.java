package org.vivek.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vivek.springexample.dao.JdbcDAOImpl;

public class JdbcMain {

	public static void main(String a[]) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-aop.xml");
		JdbcDAOImpl impl = (JdbcDAOImpl) ctx.getBean("jdbcDAOImpl");
		org.vivek.springexample.model.Circle circle = impl.getCircle(1);
		System.out.println(circle.getName());
	}
}
