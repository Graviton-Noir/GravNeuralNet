package com.graviton.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	public Fenetre()
	{
		this.setTitle("Creatures survival learning");
		this.setSize(600, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public void addContent(JPanel jpanel) {
		this.addContent(jpanel);
	}
}
