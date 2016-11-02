package com.graviton.env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Fire extends Environment {
	
	public Fire(Point p) {
		position = p;
		width = 30;
		height = 30;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawOval(position.x - width / 2, position.y - height / 2, width,  height);
		g.setColor(Color.BLACK);
	}
}
