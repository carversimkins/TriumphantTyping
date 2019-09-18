import java.awt.Color;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Projectile extends JLabel {
	int speed;
	boolean alive = true;
	String direction = null;
	int x;
	int y;
	String type;

	/*
	Projectile constructor
	Input: x coordinate, y coordinate, direction, speed, type
	*/
	Projectile(int x, int y, String d, int spd, String type){
		this.type = type;
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("fireball.png"));;
		switch(type){
			case "fireball": icon = new ImageIcon(getClass().getClassLoader().getResource("fireball.png")); break;
			case "laser": icon = new ImageIcon(getClass().getClassLoader().getResource("Laser.png")); break;
			case "sword":
				if(AdventureManager.toon.direction.equals("right")) icon = new ImageIcon(getClass().getClassLoader().getResource("SwordProjectile.png"));
				if(AdventureManager.toon.direction.equals("left")) icon = new ImageIcon(getClass().getClassLoader().getResource("SwordProjectileLeft.png"));
				break;
		}
		setIcon(icon);
		AdventureManager.mainPanel.add(this);
		this.direction = d;
		this.x = x;
		this.y = y;
		this.speed = spd;
		setBackground(Color.red);
		setSize(50, 50);
		setLocation(x, y);
	}
	Projectile(int spd, String type, Enemy e){
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("fireball.png"));;
		switch(type){
			case "fireball": icon = new ImageIcon(getClass().getClassLoader().getResource("fireball.png")); break;
			case "laser": icon = new ImageIcon(getClass().getClassLoader().getResource("Laser.png")); break;
			case "sword":
				if(AdventureManager.toon.direction.equals("right")) icon = new ImageIcon(getClass().getClassLoader().getResource("SwordProjectile.png"));
				if(AdventureManager.toon.direction.equals("left")) icon = new ImageIcon(getClass().getClassLoader().getResource("SwordProjectileLeft.png"));
				break;
		}
	}

	/*
	This method updates
	*/
	public void update(){
		//remove projectile when hitting edge
		if(this.collision()) kill();
		//move the projectile every time update is called
		if(this.direction.equals("right")) this.x += this.speed;
		else this.x -= this.speed;
		setLocation(this.x, this.y);
		repaint();


	}

	public boolean collision(){
		if(this.x+50 > 1194 || this.x < 0) return true;
		return false;
	}

	//method to delete the projectile
	public void kill(){
		AdventureManager.currentRoom.projectiles.remove(this);
		AdventureManager.currentRoom.enemyProjectiles.remove(this);
		this.setVisible(false);
	}

	/*
	Returns the x coordinate for the projectile
	*/
	public int getX(){
		return this.x;
	}

	/*
	Returns the x coordinate for the projectile
	*/
	public int getY(){
		return this.y;
	}
	public void doDamage(){
	Adventurer.health -= AdventureManager.currentRoom.level;
	kill();
	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
	}
}
