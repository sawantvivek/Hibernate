package org.vivek.springexample;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SuppressWarnings("deprecation")
public class ShapeApp {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		Shape shape = (Shape) context.getBean("Circle");
		shape.draw();
		
		System.out.println(context.getMessage("greeting", null, "default hello !!!", Locale.UK));
	}

}
