package com.graviton.env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Diamond extends Item {
	
	public Diamond(Point p) {
		this.position = p;
		this.width = 4;
		this.height = 8;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(position.x - width / 2, position.y - height / 2, width, height);
		g.setColor(Color.BLACK);
	}
}
