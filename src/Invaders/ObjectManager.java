package Invaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;

	ArrayList<Projectile> p;
	ArrayList<Alien> a;
	long enemyTimer;
	int enemySpawnTime;
	int score;
	

	public ObjectManager(Rocketship rocket) {

		this.rocket = rocket;
	
		p = new ArrayList<Projectile>();
		a = new ArrayList<Alien>();	
		enemyTimer = 0;
		enemySpawnTime = 1000;
		score = 0;
		
	}

	public void update() {

		rocket.update();

		for (int x = 0; x < p.size(); x++) {

			p.get(x).update();

		}
		
		for (int x = 0; x < a.size(); x++) {

			a.get(x).update();

		}

	}

	public void draw(Graphics g) {

		rocket.draw(g);

		for (int x = 0; x < p.size(); x++) {

			p.get(x).draw(g);

		}
		
		for (int x = 0; x < a.size(); x++) {

			a.get(x).draw(g);

		}

	}

	public void addProjectile(Projectile p1) {
		p.add(p1);

	}
	
	public void addAlien(Alien a1) {
		
		a.add(a1);
	}
	
	

	public void manageEnemies(){ //I haven't made them turn and stuff
		
	        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	                addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));

	enemyTimer = System.currentTimeMillis();
	        }
	}
	
	public void purgeObjects() { // Have no idea what this does
		
		for (int i = 0; i < p.size(); i++) {
			if (!p.get(i).isAlive) {
				p.remove(i);
			}
		}
		
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).isAlive) {
				a.remove(i);
			}
		}
		
		if (!rocket.isAlive) {
			
			//currentState = END_STATE;
			
		}
		
	}
	
	public void checkCollision() {
		
		for(Alien al : a){

	        if(rocket.collisionBox.intersects(al.collisionBox)){

	                rocket.isAlive = false;
	                System.out.println("ROCKETISDEAD");
	        }
	        
	        for (Projectile pl : p) {
	        	
	        	 if(pl.collisionBox.intersects(al.collisionBox)){

		                al.isAlive = false;
		                pl.isAlive = false;
		                System.out.println("ALIENISDEAD");
		                score++;
		        }
	        	
	        }

	}
		
	
		
		
	}

	public boolean toEndState() {
		
		
		
		if (rocket.isAlive == false) {
			rocket.isAlive = true;
			a.clear();
			
			
			
			
				return true;
		}
		return false;
		
	
		
		
		
		
	}
	
	public int getScore() {
		
		
		return score;
		
	}
	

}