package org.vivek.springexample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware {
	
	

	public Point center;

	public int centervalue = 0;
	
	private ApplicationEventPublisher publisher;

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

	@Resource(name="pointB")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		
		System.out.println(this.getMessageSource().getMessage("display.circle", null, "Default Circle", null));
		System.out.println(this.getMessageSource().getMessage("display.point", new Object []{center.getX(),center.getY()}, "Default Circle", null));
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);

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

	public void setApplicationEventPublisher(
			ApplicationEventPublisher publisher) {
		this.publisher = publisher; 
	}

}
