package com.graviton.util;

import java.awt.Point;

/**
 * On part sur l'utilisation de point et Vector2 n'est qu'un outil de calcul
 * @author SC
 *
 */
public class Vector2 {
	
	public static double length(Point a, Point b) {
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
	}
	
	/**
	 * From the origin
	 * @param p
	 * @return
	 */
	public static double length(Point p) {
		return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
	}
	
	public static void makeUnit(Point p) {
		p.setLocation(p.getX() / length(p), p.getY() / length(p));
	}
	
	public static void makeUnit(Point a, Point b) {
		b.setLocation(b.getX() / length(a, b), b.getY() / length(a, b));
	}
	
	public static void turn45Left(Point a, Point b) {
		b.setLocation((b.getX() - a.getX()) * Math.cos(Math.PI / 4), (b.getY() - a.getY()) * Math.sin(Math.PI / 4));
	}
	
	public static void turn45Right(Point a, Point b) {
		b.setLocation((b.getX() - a.getX()) * Math.cos(-Math.PI / 4), (b.getY() - a.getY()) * Math.sin(-Math.PI / 4));
	}
}
