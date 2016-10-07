package com.graviton.neuralNetwork;

import javax.swing.JFrame;

public class GraphFrame extends JFrame {
	
	private GraphPanel panel;
	
	public GraphFrame(Network network, int iterationMax, Interface frame)
	{
		this.setTitle("Graph Apprentissage neural");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(frame.getLocation().x + frame.getWidth(), frame.getLocation().y);
		
		panel = new GraphPanel(network, 600, 300, 10, iterationMax);
		
		this.setContentPane(panel);
		this.setVisible(true);
	}
	
	public void display(int iteration)
	{
		panel.updateGraph(iteration);
		panel.repaint();
	}
}
