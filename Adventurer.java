import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Adventurer extends JLabel implements KeyListener{
	//initialize all variables for the adventurer class
	int x = 0;
	int y = 0;

	int speed = 2;
	static int strength = 0, vitality = 0, dexterity = 0, intelligence = 0;
	int jumpCount = 25 + (Adventurer.dexterity/2);
	int gravity = 3;
	String direction = null;
	boolean oneLetter = false;
	public boolean plat = false, jump;
	public boolean cantJump = false;
	static int mana = 10;
	static int maxMana = 10;
	boolean yes = false;
	static Inventory inven = new Inventory();

	public static boolean[] keyss = new boolean[256];
	static public int health = 20, maxHealth = 20;
	int jumpCounter;
	boolean jumping = false;
	ImageIcon leftImage, rightImage, run, idle;
	Timer jumpTimer, fallTimer;
	int keys;

	//Constructor for the Adventurer class
	Adventurer(int floor, int position){
		leftImage = new ImageIcon(getClass().getClassLoader().getResource("SnowmanLeft.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource("SnowmanRight.png"));

		setIcon(rightImage);

		y = floor - 100;
		x = position;
		setSize(50, 100);
		setLocation(x,y);
		setBackground(Color.red);

	}
	@Override
	public void keyPressed(KeyEvent e) {
		keyss[e.getKeyCode()] = true;


	}

	@Override
	public void keyReleased(KeyEvent e) {

		keyss[e.getKeyCode()] = false;
		jumping=false;
		yes = true;
		oneLetter = true;

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public boolean iskeyDown(int key) {
		return keyss[key];
	}
	/*
	This method is contantly detecting the changes given by the player as well as a variety of collisions.
	@Param none
	@Returns none
	*/
	public void Update() {
		if(health <= 0) lost();

		for(int i = 0; i < AdventureManager.currentRoom.enemyProjectiles.size(); i++){ //Checks for collision with enemy projectiles
			if(((AdventureManager.currentRoom.enemyProjectiles.get(i).x + 50 > x) && (AdventureManager.currentRoom.enemyProjectiles.get(i).x + 50 < x+50) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50< y+98) )
					|| ((AdventureManager.currentRoom.enemyProjectiles.get(i).x > x) && (AdventureManager.currentRoom.enemyProjectiles.get(i).x < x+50)  &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50< y+98) )

						) {

					AdventureManager.currentRoom.enemyProjectiles.get(i).doDamage();

				}
		}
		/*
		This chunk of code checks for the controls for the character (Moving left and right, jumping, opening the notebook)
		*/
		if(iskeyDown(KeyEvent.VK_W) && (AdventureManager.n.on == false) && (cantJump == false)){
			jump();
		}
		if(iskeyDown(KeyEvent.VK_L) && (AdventureManager.n.on == false)){

		}
		if(iskeyDown(KeyEvent.VK_D) && (AdventureManager.n.on == false)){
		 x += speed; setLocation(x,y); setIcon(rightImage); direction = "right";
		}
		if(iskeyDown(KeyEvent.VK_A) && (AdventureManager.n.on == false)){
			 x -= speed; setLocation(x,y); setIcon(leftImage); direction = "left";
			}
		if(iskeyDown(KeyEvent.VK_SPACE)){
			if((AdventureManager.n.on == false) && (yes == true)) {
				AdventureManager.n.showPad();
				//slowDown();
				yes = false;
			}
			 else if((AdventureManager.n.on == true) && (yes == true)) {
				AdventureManager.n.hidePad();
				AdventureManager.currentRoom.t.setDelay(5);
				yes = false;
			}

			/*
			This code handles the event handlers for checking input for the notebook. Mostly boiler plate code for each letter.
			*/
		}
		if((iskeyDown(KeyEvent.VK_A)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter A
			oneLetter = false;
			AdventureManager.n.letters.add("a");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_B)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter B
			oneLetter = false;
			AdventureManager.n.letters.add("b");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_C)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter C
			oneLetter = false;
			AdventureManager.n.letters.add("c");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_D)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter D
			oneLetter = false;
			AdventureManager.n.letters.add("d");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_E)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter E
			oneLetter = false;
			AdventureManager.n.letters.add("e");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_F)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter F
			oneLetter = false;
			AdventureManager.n.letters.add("f");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_G)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter G
			oneLetter = false;
			AdventureManager.n.letters.add("g");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_H)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter H
			oneLetter = false;
			AdventureManager.n.letters.add("h");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_I)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter I
			oneLetter = false;
			AdventureManager.n.letters.add("i");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_J)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter J
			oneLetter = false;
			AdventureManager.n.letters.add("j");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_K)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter K
			oneLetter = false;
			AdventureManager.n.letters.add("k");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_L)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter L
			oneLetter = false;
			AdventureManager.n.letters.add("l");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_M)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter M
			oneLetter = false;
			AdventureManager.n.letters.add("m");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_N)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter N
			oneLetter = false;
			AdventureManager.n.letters.add("n");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_O)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter O
			oneLetter = false;
			AdventureManager.n.letters.add("o");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_P)) && (AdventureManager.n.on == true) && (oneLetter == true)) {  //Checks for the input of letter P
			oneLetter = false;
			AdventureManager.n.letters.add("p");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_Q)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter Q
			oneLetter = false;
			AdventureManager.n.letters.add("q");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_R)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter R
			oneLetter = false;
			AdventureManager.n.letters.add("r");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_S)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter S
			oneLetter = false;
			AdventureManager.n.letters.add("s");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_T)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter T
			oneLetter = false;
			AdventureManager.n.letters.add("t");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_U)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter U
			oneLetter = false;
			AdventureManager.n.letters.add("u");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_V)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter V
			oneLetter = false;
			AdventureManager.n.letters.add("v");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_W)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter W
			oneLetter = false;
			AdventureManager.n.letters.add("w");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_X)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter X
			oneLetter = false;
			AdventureManager.n.letters.add("x");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_Y)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter Y
			oneLetter = false;
			AdventureManager.n.letters.add("y");
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_Z)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for the input of letter Z
			oneLetter = false;
			AdventureManager.n.letters.add("z");
			AdventureManager.n.updateWord();
		}
		if((iskeyDown(KeyEvent.VK_BACK_SPACE)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Checks for a backspace
			oneLetter = false;
			if(!AdventureManager.n.letters.isEmpty()) AdventureManager.n.letters.remove(AdventureManager.n.letters.size()-1);
			AdventureManager.n.updateWord();

		}
		if((iskeyDown(KeyEvent.VK_ENTER)) && (AdventureManager.n.on == true) && (oneLetter == true)) { //Submits the word when ENTER is pressed
			oneLetter = false;
			AdventureManager.n.submitWord();
			AdventureManager.n.letters.clear();
			AdventureManager.n.updateWord();
			AdventureManager.n.hidePad();

		}


		if((y+100)>=AdventureManager.floorHeight) { //If the player is on the floor, stop gravity
			jump = false;
			y= AdventureManager.floorHeight -100;
			gravity *= 0;
			jumpCount = 25 + (Adventurer.dexterity/2);

		}
		else {
			gravity = 3;}

		y += gravity; setLocation(x,y);
		jump = false;
		}

		/*
		Method for player jumping
		@Param none
		@Returns none
		*/
	public void jump() {
		jump = true;
		if(jumpCount >= 0) {
			y -= speed+3 + (jumpCount/4);
			jumpCount--;
		}
	}
	/*
	Slows down time by incresaing the delay of the main timer
	@Param none
	@Returns none
	*/
	public void slowDown() {
		AdventureManager.currentRoom.t.setDelay(100);
	}
	/*
	Method for when the player loses, resets progress, takes some of the players gold, shows a screen to shame them
	@Param none
	@Returns none
	*/
	public void lost() {
		for(int i =0; i<AdventureManager.currentRoom.traps.size(); i++) {
			AdventureManager.currentRoom.traps.get(i).setVisible(false);
			AdventureManager.currentRoom.traps.remove(AdventureManager.currentRoom.traps.get(i));
		}
		AdventureManager.gold = (int)((double)AdventureManager.gold * 0.6);
		AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
		AdventureManager.dataPanel.setVisible(true);
		AdventureManager.currentRoom.t.stop();
		 AdventureManager.toon.cantJump = false;
		AdventureManager.currentRoom.deleteMain();
		AdventureManager.spawnRoom.make();
		AdventureManager.mainPanel.setVisible(false);
		AdventureManager.mainPanel.add(AdventureManager.dataPanel);
		AdventureManager.lossPanel.setVisible(true);

	}
	/*
	Method for dealing damage to the player, updates all UI when it happens.
	@Param none
	@Returns none
	*/
	public void damage(int amount){
		this.health -= amount;
		AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
	}
	/*
	Like damage but for mana instead of health, for when using a spell that costs mana. 
	@Param none
	@Returns none
	*/
	public static void costmana(int amount){
		mana -= amount;
		if(mana > maxMana) mana = maxMana;
		AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
	}

	}
