package org.vivek.springexample;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2353376758352694185L;

	public DrawEvent(Object source) {
		super(source);
	}
	
	
	public String toString(){
		return "Drawing Event occured";
	}

}
