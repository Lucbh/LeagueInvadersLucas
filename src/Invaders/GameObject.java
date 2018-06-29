package Invaders;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	boolean isAlive;
	Rectangle collisionBox;

	public GameObject(int a, int b, int c, int d) {
		/*
		 * don't know how to " Add parameters to your constructor that match the member
		 * variables and use these to initialize the member variables."
		 */

		x = a;
		y = b;
		width = c;
		height = d;
		isAlive = true;
		collisionBox = new Rectangle(x,y,width,height);

	}

	public void update() {
		
		
		collisionBox.setBounds(x,y,width,height);

	}

	public void draw(Graphics gr) {

	}

}
