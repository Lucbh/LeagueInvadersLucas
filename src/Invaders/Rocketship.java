package Invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	 int speedX;
	 int speedY;
	
	public Rocketship(int bob, int sally, int jill, int susan) {
		
		super(bob, sally, jill, susan);
		
		x = bob;
		y = sally;
		width = jill;
		height = susan;
		
		speedX = 0;
		speedY = 0;
		
	}
	
	
	
	public void update() {
		super.update();
		
		x+=speedX;
		y+=speedY;
		
		/***
		 * AT THE END OF 8, BEGINNING OF 9
		 * 
		 */
		
	}
	
	public void draw(Graphics g) {
		
		
		 g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		 g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		 
		
	}

}
