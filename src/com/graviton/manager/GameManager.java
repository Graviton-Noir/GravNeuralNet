package com.graviton.manager;

import java.awt.Point;
import java.util.ArrayList;

import com.graviton.env.Apple;
import com.graviton.env.Creature;
import com.graviton.env.Diamond;
import com.graviton.env.Environment;
import com.graviton.env.Fire;
import com.graviton.env.Item;
import com.graviton.env.Water;

public class GameManager {
	
	private int widthFrame;
	private int heightFrame;
	
	private ArrayList<Item> itemList;
	private ArrayList<Environment> envList;
	private ArrayList<Creature> creatureList;
	
	public GameManager(int width, int height) {
		itemList = new ArrayList<>();
		envList = new ArrayList<>();
		creatureList = new ArrayList<>();
		
		widthFrame = width;
		heightFrame = height;
	}
	
	public void gen(int seed) {
		for (int i = 0; i < seed; ++i) {
			creatureList.add(new Creature(
					new Point((int)(10 + Math.random() * (widthFrame - 10)),
							(int)(10 + Math.random() * (heightFrame - 10))),
					new Point((int)(0.1d + Math.random() * (widthFrame - 10)),
							(int)(0.1d + Math.random() * (heightFrame - 10)))));
			
			itemList.add(new Apple(new Point((int)(10 + Math.random() * (widthFrame - 10)),
					(int)(10 + Math.random() * (heightFrame - 10)))));
			
			itemList.add(new Diamond(new Point((int)(10 + Math.random() * (widthFrame - 10)),
					(int)(10 + Math.random() * (heightFrame - 10)))));
			
			envList.add(new Water(new Point((int)(30 + Math.random() * (widthFrame - 30)),
					(int)(30 + Math.random() * (heightFrame - 30)))));
			
			envList.add(new Fire(new Point((int)(50 + Math.random() * (widthFrame - 50)),
					(int)(50 + Math.random() * (heightFrame - 50)))));
		}
	}
	
	public void update() {
		for (Creature cr : creatureList) {
			cr.update();
		}
	}
	
	//////////////////////////////////
	//			GET & SET			//
	//////////////////////////////////

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<Environment> getEnvList() {
		return envList;
	}

	public void setEnvList(ArrayList<Environment> envList) {
		this.envList = envList;
	}

	public ArrayList<Creature> getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(ArrayList<Creature> creatureList) {
		this.creatureList = creatureList;
	}
}
