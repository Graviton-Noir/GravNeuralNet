package com.graviton;

import com.graviton.graphics.Arena;
import com.graviton.graphics.Fenetre;
import com.graviton.manager.GameManager;

public class Main {

	public static void main(String[] args) {
		
		// TEST
		int loop = 10000;
		int widthFrame = 600;
		int heightFrame = 480;

		GameManager gameManager = new GameManager(widthFrame, heightFrame);
		gameManager.gen(5);
		
		Arena arena = new Arena(gameManager.getCreatureList(),
				gameManager.getItemList(),
				gameManager.getEnvList());
		
		Fenetre frame = new Fenetre(widthFrame, heightFrame);
		frame.addContent(arena);
		
		for (int i = 0; i < loop; ++i) {
			gameManager.update();
			
			try {
				Thread.sleep(33);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			frame.draw();
		}
	}
}
