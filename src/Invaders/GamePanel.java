package Invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer time;

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;
	Font subtitleFont;
	Rocketship r;
	// LeagueInvaders l;

	int rX = 250;
	int rY = 700;

	ObjectManager ob;
	
	
	 public static BufferedImage alienImg;

     public static BufferedImage rocketImg;

     public static BufferedImage bulletImg;

     public static BufferedImage spaceImg;



	public GamePanel() {

		time = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 25);

		r = new Rocketship(rX, rY, 50, 50);
		// l = new LeagueInvaders();

		ob = new ObjectManager(r);
		
		
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("badjet.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("jet.png"));

             
             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.jpg"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }

	}

	public void startGame() {

		time.start();

	}

	public void updateMenuState() {
		
		ob.score = 0;

	}

	public void updateGameState() {

		ob.update();
		ob.manageEnemies();
		ob.checkCollision();
		ob.purgeObjects();  
		ob.getScore();
		
		
		if (ob.toEndState() == true) {
			currentState = END_STATE;
			
		}
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {

		g.setColor(Color.DARK_GRAY);

		g.fillRect(0, 0, 500, 800);

		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("LEAGUE INVADERS", 25, 300);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 130, 500);
		g.drawString("Press SPACE for instructions", 90, 700);
	}

	public void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);

		g.fillRect(0, 0, 500, 800);

		ob.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 500, 800);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("YOU DIED", 120, 300);
		g.setFont(subtitleFont);
		g.drawString("YOU GOT " + ob.getScore() + " KILLS", 130, 500);
		g.drawString("Press ENTER to start over", 100, 700);

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		repaint();

		// System.out.println("It works!!!");

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("I am going so fast");

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState++;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			
		
			if (currentState == MENU_STATE) {
				r = new Rocketship(rX, rY, 50, 50);
				
				ob = new ObjectManager(r);
				
			}
			
			

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) { // I need to make it more smooth

			r.speedY = -5;

		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			r.speedY = 5;
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			r.speedX = 5;

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			r.speedX = -5;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			ob.addProjectile(new Projectile(r.x + 20, r.y, 10, 10));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Wow!!");

		if (e.getKeyCode() == KeyEvent.VK_UP) { // I need to make it more smooth

			r.speedY = 0;

		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			r.speedY = 0;
			;
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			r.speedX = 0;

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			r.speedX = 0;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Can I finish soon?!");

	}

}
