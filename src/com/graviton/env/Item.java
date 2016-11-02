package com.graviton.env;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * heritage pour importer plus d'objet par la suite
 * [SC]
 */ 
public class Item extends JPanel {

	protected Point position;
	protected int width;
	protected int height;
	
	public Item() {
		position = new Point();
		width = 0;
		height = 0;
	}
	
	//////////////////////////////////
	//			GET & SET			//
	//////////////////////////////////

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
