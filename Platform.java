import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Platform extends JLabel {
	//initialize all variables
	private int x, y;
	Timer time;
	public Platform() {
		x = 0;
		y = 0;
		setSize(50, 50);
		setLocation(x,y);
		start();

	}

	//Constructor for Platform class
	public Platform(int inX, int inY) {
		x = inX;
		y = inY;
		setSize(50, 50);
		setLocation(x,y);
		start();
	}

	/*
	Sets the block icon and background
	@Param:none
	@Return: none
	*/
	public void start() {
		ImageIcon block;
		block = new ImageIcon(getClass().getClassLoader().getResource("bloc.png"));
		setIcon(block);
		setBackground(Color.blue);
		//AdventureManager.mainPanel.add(this);
		}

		/*
		Update function for Platform
		@Param: none
		@Return: none
		*/
	public void update() {
		//checks for collisions in all directions
		if((AdventureManager.toon.y < y+50) && (AdventureManager.toon.y > y+40) &&
				(((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50))
				|| ((AdventureManager.toon.x+50 > x) && AdventureManager.toon.x+50 < x+50))) {
			AdventureManager.toon.y = y+55; AdventureManager.toon.repaint();
		}
		else if((AdventureManager.toon.y+100 < y) && (AdventureManager.toon.y+100 > y-5) && (((AdventureManager.toon.x >= x) && (AdventureManager.toon.x <= x+50))
				|| ((AdventureManager.toon.x+50 >= x) && (AdventureManager.toon.x+50 <= x+50))
				|| ((AdventureManager.toon.x+25 >= x) && AdventureManager.toon.x+25 <= x+50))) {
		 AdventureManager.toon.y = y-105; AdventureManager.toon.repaint();
		 AdventureManager.toon.jumpCount = 25;
		}
		else if(((AdventureManager.toon.x + 50) > x) && ((AdventureManager.toon.x+50)<x+20) && ( //Left Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+45)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+45)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+45)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+45))


				)     ) {
			AdventureManager.toon.x = x-51; AdventureManager.toon.repaint();
		}
		else if(((AdventureManager.toon.x) > x+40) && ((AdventureManager.toon.x)<x+50) && ( //Right Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+50)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+50)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+50)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+50))


				)     ) {
			AdventureManager.toon.x = x+51; AdventureManager.toon.repaint();
		}
		//checks for collisions with enemies
		for(int i = 0; i < AdventureManager.currentRoom.enemies.size(); i++) {
			if((AdventureManager.currentRoom.enemies.get(i).y < y+50) && (AdventureManager.currentRoom.enemies.get(i).y > y+40) &&
					(((AdventureManager.currentRoom.enemies.get(i).x > x) && (AdventureManager.currentRoom.enemies.get(i).x < x+50))
					|| ((AdventureManager.currentRoom.enemies.get(i).x+50 > x) && AdventureManager.currentRoom.enemies.get(i).x+50 < x+50))) {
				AdventureManager.currentRoom.enemies.get(i).y = y+55; AdventureManager.currentRoom.enemies.get(i).repaint();
			}
			else if((AdventureManager.currentRoom.enemies.get(i).y+100 < y) && (AdventureManager.currentRoom.enemies.get(i).y+100 > y-5) && (((AdventureManager.currentRoom.enemies.get(i).x >= x) && (AdventureManager.currentRoom.enemies.get(i).x <= x+50))
					|| ((AdventureManager.currentRoom.enemies.get(i).x+50 >= x) && (AdventureManager.currentRoom.enemies.get(i).x+50 <= x+50))
					|| ((AdventureManager.currentRoom.enemies.get(i).x+25 >= x) && AdventureManager.currentRoom.enemies.get(i).x+25 <= x+50))) {
			 AdventureManager.currentRoom.enemies.get(i).y = y-105; AdventureManager.currentRoom.enemies.get(i).repaint();

			}
			else if(((AdventureManager.currentRoom.enemies.get(i).x + 50) > x) && ((AdventureManager.currentRoom.enemies.get(i).x+50)<x+20) && ( //Left Collision
					((AdventureManager.currentRoom.enemies.get(i).y > y) && (AdventureManager.currentRoom.enemies.get(i).y < y+50)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 25 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 25 < y+45)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 50 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 50 < y+45)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 75 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 75 < y+45)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 100 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 100 < y+45))


					)     ) {
				AdventureManager.currentRoom.enemies.get(i).x = x-51; AdventureManager.currentRoom.enemies.get(i).repaint();
			}
			else if(((AdventureManager.currentRoom.enemies.get(i).x) > x+40) && ((AdventureManager.currentRoom.enemies.get(i).x)<x+50) && ( //Right Collision
					((AdventureManager.currentRoom.enemies.get(i).y > y) && (AdventureManager.currentRoom.enemies.get(i).y < y+50)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 25 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 25 < y+50)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 50 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 50 < y+50)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 75 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 75 < y+50)) ||
					((AdventureManager.currentRoom.enemies.get(i).y + 100 > y) && (AdventureManager.currentRoom.enemies.get(i).y + 100 < y+50))


					)     ) {
				AdventureManager.currentRoom.enemies.get(i).x = x+51; AdventureManager.currentRoom.enemies.get(i).repaint();
			}
		}
	}
}
