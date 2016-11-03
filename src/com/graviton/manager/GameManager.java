package com.graviton.manager;

import java.util.ArrayList;

import com.graviton.env.Creature;
import com.graviton.env.Environment;
import com.graviton.env.Item;

public class GameManager {
	
	private ArrayList<Item> itemList;
	private ArrayList<Environment> envList;
	private ArrayList<Creature> creatureList;
	
	public GameManager() {
		itemList = new ArrayList<>();
		envList = new ArrayList<>();
		creatureList = new ArrayList<>();
	}
	
	public void update() {
		// TODO [SC] - update every element of the game
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
