package org.vivek.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

	public Point center;
	
	public int centervalue = 0;

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
	@Qualifier("CircleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Circle: Center point X: " + center.getX()
				+ " and Y : " + center.getY());
	}

}
