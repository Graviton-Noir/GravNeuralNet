package com.graviton.neuralNetwork;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double tab[] = null;
	Network network = null;
	
	public Panneau(double tab[])
	{
		this.tab = tab;	
	}
	
	public Panneau(double tab[], Network network) {
		this.tab = tab;
		this.network = network;
	}
	
	public void updatePanneau(double tab[])
	{
		this.tab = tab;
	}
	
	public void eraseScreen(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
	}
	
	public void paintComponent(Graphics g)
	{
		eraseScreen(g);
		
		g.drawString("Input (0, 0) : " + tab[0], 10, 200);
		g.drawString("Input (0, 1) : " + tab[1], 10, 215);
		g.drawString("Input (1, 0) : " + tab[2], 10, 230);
		g.drawString("Input (1, 1) : " + tab[3], 10, 245);
		g.drawString("Global ERROR : " + network.getGlobalError(), 10, 270);
		
		if (network != null) {
			for (int l = 0; l < network.getLayers().size(); ++l) {
				for (int n = 0; n < network.getLayers().get(l).getNeurons().size(); ++n) {
					network.getLayers().get(l).getNeurons().get(n).paintComponent(g);
				}
			}
		}
	}
}
