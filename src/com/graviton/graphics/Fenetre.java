package com.graviton.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	public Fenetre(int width, int height)
	{
		this.setTitle("Creatures survival learning");
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public void addContent(JPanel jpanel) {
		this.setContentPane(jpanel);
	}
	
	public void draw() {
		this.getContentPane().repaint();
	}
}
