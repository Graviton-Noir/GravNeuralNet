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
	
	private Point direction;
	private Point position;
	//private Vector2 range;
	
	private int width;
	private int height;
	
	private boolean isBurned;
	private boolean transports;
	private boolean hungry;
	
	private int life;
	
	//private Network brain;
	
	public Creature(Point position, Point direction) {
		width = 5;
		height = 5;
		
		this.position = position;
		this.direction = direction;
		
		speed = 0.5f;
		rotationSpeed = 0.5f;
		
		life = 100;
		
		isBurned = false;
		transports = false;
		hungry = false;
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
	
	public void update() {
		// TODO [SC] - Faire fonctionner le cerveau
		// En fonction de la sortie du réseau de neurone, on dit si on veut faire avancer la bestiole ou la faire tourner
		
		// 1 : gauche
		// 2 : droite
		int TEST = 1;
		
		if (TEST == 1) {
			// TODO [SC] - Obtenir vecteur orthogonale
			// Et modifier la direction
		} else {
			
		}
		
		position.setLocation(position.getX() + direction.getX() * speed, position.getY() + direction.getY() * speed);
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
