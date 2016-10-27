package com.graviton.env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.graviton.neuralNetwork.Network;
import com.graviton.util.Vector2;

public class Creature extends JPanel {

	private float speed;
	private float rotationSpeed;
	
	private Vector2 direction;
	private Point position;
	private Vector2 range;
	
	private int width;
	private int height;
	private Color color;
	
	private boolean isBurned;
	private boolean transports;
	private boolean hungry;
	
	private int life;
	
	private Network brain;
	
	public Creature() {
		width = 5;
		height = 5;
		
		color = Color.WHITE;
	}
	
	public void burned() {
		isBurned = true;
	}
	
	public void starves() {
		hungry = true;
	}
	
	public void transports() {
		transports = true;
	}
	
	public void swims() {
		isBurned = false;
	}
	
	public void drop() {
		transports = false;
	}
	
	public void eats() {
		hungry = false;
	}
	
	
	public void drawComponent(Graphics g) {
		if (isBurned) {
			g.setColor(Color.RED);
		} else if (hungry) {
			g.setColor(Color.YELLOW);
		} else if (transports) {
			g.setColor(Color.CYAN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawOval(position.x, position.y, width, height);
	}
}
