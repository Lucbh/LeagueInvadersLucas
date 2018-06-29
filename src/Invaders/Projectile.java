package Invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speedP;

	public Projectile(int bob, int sally, int jill, int susan) {

		super(bob, sally, jill, susan);

		x = bob;
		y = sally;
		width = jill;
		height = susan;

		speedP = 10;

	}

	public void update() {
		super.update();
		y -= speedP;

		if (y < 0) {

			isAlive = false;

		}

	}

	public void draw(Graphics g) {

		g.setColor(Color.RED);

		g.fillRect(x, y, width, height);

	}

}
