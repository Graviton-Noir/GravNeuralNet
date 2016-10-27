package com.graviton.util;

import java.awt.Point;

public class Vector2 {

	private Point a;
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
	
	public static double length(Point a, Point b) {
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
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
