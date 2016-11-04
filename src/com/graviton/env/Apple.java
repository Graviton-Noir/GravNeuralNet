package com.graviton.env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Apple extends Item {
	
	public Apple(Point point) {
		this.position = point;
		this.width = 10;
		this.height = 10;
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("FUCKING CHILDREN");
		g.setColor(Color.RED);
		g.drawOval(position.x - width / 2, position.y - height / 2, width, height);
		g.setColor(Color.BLACK);
	}
}
