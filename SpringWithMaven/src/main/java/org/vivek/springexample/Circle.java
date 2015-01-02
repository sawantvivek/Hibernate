package org.vivek.springexample;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

	public Point center;

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Circle: Center point X: " + center.getX()
				+ " and Y : " + center.getY());
	}

}
