package com.graviton.neuralNetwork;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	
	private Network network;
	private int iterationMax;
	
	private int width;
	private int height;
	private int offset;
	private Point origin;
	
	private ArrayList<Point> line;
	private Point point;
	
	public GraphPanel(Network network, int width, int height, int offset, int iterationMax) {
		this.network = network;
		
		this.width = width;
		this.height = height;
		this.offset = offset;
		
		this.iterationMax = iterationMax;
		
		origin = new Point(offset, offset + height / 2);
		line = new ArrayList<>();
	}
	
	public void updateGraph(int iteration) {
		point = computePoint(iteration, network.getGlobalError(), 1);
	}
	
	private Point computePoint(int iteration, double error, double errorMax) {
		Point pt = new Point(origin.x + (iteration / iterationMax) * width,
				(int) (origin.y + (error / errorMax) * height / 2));
		return pt;
	}
	
	
	// GRAPHICAL PART
	
	/**
	 * Dessine le repère du graphique. Ne supporte pas le rafraichissement/effacement de l'écran
	 * @param g
	 * @param width
	 * @param height
	 */
	private void displayRepere(Graphics g, int width, int height) {
		
		g.setColor(Color.black);
		
		g.drawLine(offset, offset, offset, height + offset);
		g.drawLine(offset, height / 2 + offset, width + offset, height / 2 + offset);
	}
	
	/**
	 * Utilsé pour tracer une courbe si rafraichissement, avec une liste de point (line)
	 * @param g
	 */
	private void drawLine(Graphics g) {
		
		g.setColor(Color.blue);
		Point pt;
		
		for (int i = 0; i < line.size(); ++i) {
			
			pt = line.get(i);
			g.drawRect(pt.x, pt.y, 1, 1);
		}
	}
	
	/**
	 * Dessine un point sur l'ecran, ce pas utiliser s'il y a effacement d'écran
	 * @param g
	 * @param point
	 */
	private void drawPoint(Graphics g, Point point) {
		
		g.setColor(Color.blue);
		
		g.drawRect(point.x, point.y, 1, 1);
	}
	
	public void paintComponent(Graphics g) {
		displayRepere(g, width, height);
		drawPoint(g, point);
	}
}
