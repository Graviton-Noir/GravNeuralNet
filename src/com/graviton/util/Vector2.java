package com.graviton.util;

import java.awt.Point;

/**
 * 
 * @author SC
 *
 */
public class Vector2 {

	private Point a; // origin
	private Point b;
	
	public Vector2() {
		a = new Point();
		b = new Point();
	}
	
	public Vector2(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public double length() {
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
	}
	
	public Vector2 orthogonalLeft() {
		
		Point p = new Point();
		p.setLocation(b.getX() * (-Math.PI), b.getY() * (-Math.PI));
		
		return new Vector2(a, p);
	}
	
	public Vector2 orthogonalRight() {
		
		Point p = new Point();
		p.setLocation(b.getX() * Math.PI, b.getY() * Math.PI);
		
		return new Vector2(a, p);
	}
	
	public void makeUnit() {
		b.setLocation(b.getX() / length(), b.getY() / length());
	}
	
	//////////////////////////////////////////
	//				GET & SET				//
	//////////////////////////////////////////
	
	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}
}
