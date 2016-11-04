package com.graviton.env;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * 	Héritage pour importer plus de truc dans l'environement par la suite
 *	[SC]
 */
public class Environment extends JPanel {

	protected Point position;
	protected int width;
	protected int height;
	
	public Environment() {
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
