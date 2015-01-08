package org.vivek.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vivek.springexample.dao.HibernateImpl;
import org.vivek.springexample.model.Circle;
public class JdbcMain {

	public static void main(String a[]) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-aop.xml");
		HibernateImpl impl = (HibernateImpl) ctx.getBean("hibernateImpl");
	//	org.vivek.springexample.model.Circle circle = impl.getCircle(1);
//		System.out.println(circle.getName());
//		
//		System.out.println(impl.getcountCircle());
		/*for (Iterator iterator = impl.getDrName().iterator(); iterator.hasNext();) {
			Circle c = (Circle) iterator.next();
			System.out.println(c.getName());
		}*/
		
		impl.insertCircle(new Circle("HARAMI-2"));
	}
}
