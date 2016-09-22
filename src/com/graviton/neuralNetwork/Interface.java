package com.graviton.neuralNetwork;

import javax.swing.JFrame;

public class Interface extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Panneau pan;
	
	public Interface(double tab[], Network network)
	{
		this.setTitle("Neural Network Interface");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan = new Panneau(tab, network);
		
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
	public void display(double tab[])
	{
		System.out.println("tab : " + tab[0] + " " + tab[1]);
		pan.updatePanneau(tab);
		pan.repaint();
	}
}
