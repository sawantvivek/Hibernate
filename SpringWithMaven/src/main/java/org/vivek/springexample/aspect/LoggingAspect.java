package org.vivek.springexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(public String org.vivek.springexample.model.Circle.getName())")
	public void loggingAction(){
		System.out.println("Print logging action");
	}
}
