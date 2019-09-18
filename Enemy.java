import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
public class Enemy extends JLabel{
	int x;
	int y;
	int gravity = 3;
	 boolean alive = true;
	 String name;
	int speed = 1, level;
	JLabel mainPanel;
	 Timer time;
	int check =0;
	ImageIcon leftImage, rightImage;
	int health;
	int j, movetype = 0;
	int contact = 0;

	/*
	Constructor for a type of enemy
	@Param floor is the y value of the enemy
	@Param position is the x value of the enemy
	@Param n is the name of the enemy
	@Param l is the level of the enemy
	@Returns none
	*/
	Enemy(int floor, int position, String n, int l){
		name = n;
		alive = true;
		level = l;
		health = 2*level;
		leftImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Left.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Right.png"));
		setIcon(rightImage);

			y = floor - 100;
			x = position;
			setSize(50, 100);
			setLocation(x,y);
			setBackground(Color.red);


		}
		/*
		Constructor for a type of enemy
		@Param floor is the y value of the enemy
		@Param position is the x value of the enemy
		@Param n is the name of the enemy
		@Param l is the level of the enemy
		@Param m is the type of movement that the enemy shows
		@Returns none
		*/
	Enemy(int floor, int position, String n, int l, int m){
		name = n;
		alive = true;
		movetype = m;
		level = l;
		health = 10*level;
		leftImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Left.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Right.png"));
		setIcon(rightImage);

			y = floor - 100;
			x = position;
			setSize(50, 100);
			setLocation(x,y);
			setBackground(Color.red);


		}
	/*
	Check if the player is within 200 pixels of the enemy
	@Param: none
	@return: "left", "right", or "n" depending on whether the player is to the left, right, or not near the enemy
	*/
	public String playerNear(){
		if(AdventureManager.toon.x + 25 > x-200 && AdventureManager.toon.x +25 < x) return "left";
		else if(AdventureManager.toon.x +25 < x+250 && AdventureManager.toon.x +25 > x) return "right";
		else return "n";
	}

	/*
	Check if the player is within 50 pixels of the enemy
	@Param: none
	@return: "left", "right", or "n" depending on whether the player is to the left, right, or not near the enemy
	*/
	public String playerRealNear(){
		if(AdventureManager.toon.x + 25 > x-50 && AdventureManager.toon.x +25 < x) return "left";
		else if(AdventureManager.toon.x +25 < x+100 && AdventureManager.toon.x +25 > x) return "right";
		else return "n";
	}

	/*
	Fire a projectile based on enemy type
	@Param: direction for which direction the projectile fires in
	@Return: none
	*/
	public void fireProjectile(String direction){
		if(name.equals("Robot"))AdventureManager.currentRoom.enemyProjectiles.add(new Projectile(x,y, direction, 5, "laser"));
		else AdventureManager.currentRoom.enemyProjectiles.add(new Projectile(x,y, direction, 3, "fireball"));
	}

	/*
	Update function for the enemy
	@Param: none
	@Return: none
	*/
	public void Update() {
		//if player is near and haven't fired in a while, fire a projectile
		if(!playerNear().equals("n") && j > 250){
			fireProjectile(playerNear());
			j = 0;
		}
		j++;

		//COLLISION
		for(int i = 0; i < AdventureManager.currentRoom.projectiles.size(); i++){ //Checks for collision with player projectiles
			if(((AdventureManager.currentRoom.projectiles.get(i).x + 50 > x) && (AdventureManager.currentRoom.projectiles.get(i).x + 50 < x+50) &&(AdventureManager.currentRoom.projectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.projectiles.get(i).y + 50< y+98) )
					|| ((AdventureManager.currentRoom.projectiles.get(i).x > x) && (AdventureManager.currentRoom.projectiles.get(i).x < x+50)  &&(AdventureManager.currentRoom.projectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.projectiles.get(i).y + 50< y+98) )

						) {

					switch(AdventureManager.currentRoom.projectiles.get(i).type) {
					case "fireball": health -= AdventureManager.toon.intelligence; break;
					case "sword": health -= AdventureManager.toon.strength;
					}
					
					AdventureManager.currentRoom.projectiles.get(i).kill();
				}
		}
		if((AdventureManager.toon.y < y+50) && (AdventureManager.toon.y > y+40) && //Checks for collision with player
				(((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50))
				|| ((AdventureManager.toon.x+50 > x) && AdventureManager.toon.x+50 < x+50))) {
			AdventureManager.toon.y = y+55; AdventureManager.toon.repaint();
			if(contact <= 0){
				AdventureManager.toon.damage(1);
				contact = 50;
			}
		}
		else if((AdventureManager.toon.y+100 < y) && (AdventureManager.toon.y+100 > y-5) && (((AdventureManager.toon.x >= x) && (AdventureManager.toon.x <= x+50)) //Checks for collision with player
				|| ((AdventureManager.toon.x+50 >= x) && (AdventureManager.toon.x+50 <= x+50))
				|| ((AdventureManager.toon.x+25 >= x) && AdventureManager.toon.x+25 <= x+50))) {
		 AdventureManager.toon.y = y-105; AdventureManager.toon.repaint();
		 AdventureManager.toon.jumpCount = 25;
		 if(contact <= 0){
			 AdventureManager.toon.damage(1);
			 contact = 50;
		 }
		}
		else if(((AdventureManager.toon.x + 50) > x) && ((AdventureManager.toon.x+50)<x+20) && ( //Left Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+45)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+45)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+45)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+45))


				)     ) {
			AdventureManager.toon.x = x-51; AdventureManager.toon.repaint();
			if(contact <= 0){
				AdventureManager.toon.damage(1);
				contact = 50;
			}
		}
		else if(((AdventureManager.toon.x) > x+40) && ((AdventureManager.toon.x)<x+50) && ( //Right Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+50)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+50)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+50)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+50))


				)     ) {
			AdventureManager.toon.x = x+51; AdventureManager.toon.repaint();
			if(contact <= 0){
				AdventureManager.toon.damage(1);
				contact = 50;
			}
		}
		contact--;
		if(health<=0){
			setVisible(false);
			alive = false;
			AdventureManager.currentRoom.enemies.remove(this);
		}



			if((y+100)>=AdventureManager.floorHeight) {
				y= AdventureManager.floorHeight -100;
				gravity *= 0;


			}
			else {
				gravity = 3;}

			y += gravity; setLocation(x,y);

			switch(movetype) {
			case 0: chasePlayer(); break;
			case 1: randomMove(); break;
			case 2: dontMove(); break;
			}

			}
/*
Move the enemy randomly
@Param none
@Return none
*/
	public void randomMove() {
		Random rand = new Random();
		int moveNum = rand.nextInt(100)+100;
		check++;
		if(check >= moveNum) {
			speed = speed*-1;
			check =0;

		}

		if(speed > 0) {
			setIcon(rightImage);
		}
		else {
			setIcon(leftImage);
		}
		x += speed; setLocation(x,y); repaint();
	}
	/*
	Enemy chases the player
	@Param none
	@Return none
	*/
	public void chasePlayer() {
		if(!playerNear().equals("n")) {
			if(playerNear().equals("left")) {
				speed = -1;
			}
			else if(playerNear().equals("right")) {
				speed = 1;
			}
			x += speed; setLocation(x,y); repaint();
		}
		else {
			randomMove();
		}
		if(speed > 0) {
			setIcon(rightImage);
		}
		else {
			setIcon(leftImage);
		}

	}
	/*
	Enemy stands still
	@Param none
	@Return none
	*/
	public void dontMove() {
		speed = 0;
		if(!playerNear().equals("n")) {
			if(playerNear().equals("left")) {
				setIcon(leftImage);
			}
			else if(playerNear().equals("right")) {
				setIcon(rightImage);
			}
			repaint();
		}
	}
}
