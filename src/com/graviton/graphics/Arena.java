package com.graviton.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.graviton.env.Apple;
import com.graviton.env.Creature;
import com.graviton.env.Environment;
import com.graviton.env.Item;

public class Arena extends JPanel{
	
	// Contains all the creatures of the game
	// These lists are just pointers to the real ones
	private ArrayList<Creature> creatureList;
	private ArrayList<Item> itemList;
	private ArrayList<Environment> envList;
	
	public Arena(ArrayList creatureList, ArrayList itemList,
			ArrayList envList) {
		this.creatureList = creatureList;
		this.itemList = itemList;
		this.envList = envList;
	}
	
	public void eraseScreen(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
	}
	
	public void paintComponent(Graphics g) {
		
		eraseScreen(g);
		
		for (Environment env : envList) {
			env.paintComponent(g);
		}
		
		for (Item it : itemList) {
			it.paintComponent(g);
		}
		
		for (Creature cr : creatureList) {
			cr.paintComponent(g);
		}
	}
}
