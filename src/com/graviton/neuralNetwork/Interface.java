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
	
	// [SC] - Should not do dat ! It is just container, JPanel can handle itself
	// just use pan.invalidate();
	public void display(double tab[])
	{
		pan.updatePanneau(tab);
		pan.repaint();
	}
}
