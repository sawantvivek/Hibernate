package org.vivek.springexample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

public class Circle implements Shape {
	
	

	public Point center;

	public int centervalue = 0;

	@Autowired
	public MessageSource messageSource;
	
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public int getCentervalue() {
		return centervalue;
	}

	public void setCentervalue(int centervalue) {
		this.centervalue = centervalue;
	}

	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier(value="CircleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		
		System.out.println(this.getMessageSource().getMessage("display.circle", null, "Default Circle", null));
		System.out.println(this.getMessageSource().getMessage("display.point", new Object []{center.getX(),center.getY()}, "Default Circle", null));
		
		//System.out.println("Circle: Center point X: " + center.getX() + " and Y : " + center.getY());
	}

	@PostConstruct
	public void initalizeCircle() {
		System.out.println("initialize Circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy Circle");
	}

}
