package com.graviton.env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class House extends Environment {
	
	public House(Point p) {
		position = p;
		width = 30;
		height = 30;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawOval(position.x - width / 2, position.y - height / 2, width, height);
		g.setColor(Color.WHITE);
		g.drawOval(position.x - width / 2, position.y - height / 2, width - 5, height - 5);
		g.setColor(Color.BLACK);
	}
}
