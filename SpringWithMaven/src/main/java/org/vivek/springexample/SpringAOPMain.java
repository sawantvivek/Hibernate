package org.vivek.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vivek.springexample.service.ShapeService;

public class SpringAOPMain {
	
	public static void main(String a[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
		ShapeService service = ctx.getBean("shapeService", ShapeService.class);
		System.out.println(service.getCircle().getName());
	}
	

}
