package com.graviton;

import com.graviton.graphics.Arena;
import com.graviton.graphics.Fenetre;
import com.graviton.manager.GameManager;

public class Main {

	public static void main(String[] args) {
		
		// TEST
		int loop = 1000;

		GameManager gameManager = new GameManager();
		
		Fenetre frame = new Fenetre();
		
		Arena arena = new Arena(gameManager.getCreatureList(),
				gameManager.getItemList(),
				gameManager.getEnvList());
		
		frame.addContent(arena);
		
		for (int i = 0; i < loop; ++i) {
			
			gameManager.update();
			
			frame.invalidate();
		}
	}
}
