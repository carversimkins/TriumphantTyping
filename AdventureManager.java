import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class AdventureManager {
	//Creation of all the different variables that will be used within the creation of each individual room
	int first =0, first1=0, beginning = 0, end = 1145;
	static int floorHeight =700;
	static int gold = 5;
	static Room currentRoom;
	static Trap currentTrap = null;
	static Notepad n;
	static JPanel lossPanel;
	static int start = 0;
	ArrayList<Platform> blocks = new ArrayList<Platform>();
	ImageIcon background;
	public static Music musicPlayer = new Music();
	public static Enemy currentEnemy;
	public static Adventurer toon;
	public static Timer t;
	public static JPanel floor, dataPanel;
	public static JLabel mainPanel, healthInfo;
	public static Shop shop = new Shop();
	static Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	static Font TextFont = new Font("Comic Sans MS", Font.PLAIN, 25);
	static Treasure currentTreasure;
	static NPC currentNPC = null;
	static Room spawnRoom;
	String factoryMusic = ".//res//Laserpack.wav";
	String DRUM = ".//res//DRUM.wav";


	/*This method actually generates the world, by creating the different room objects.
	 *It then creates the relationship between the different Room objects using the addLeftRoom and addRightRoom methods
	 *@Param none
	 *@returns none
	 * */
	public void createWorld() {
//		musicPlayer.setFile(".//res//CarverGameMusic.wav");
//		musicPlayer.play(); first++;
		Main.window.setVisible(true);

		//initialization of each room in the game
		Room forestRoom1 = new Room("Sky"); forestRoom1.setRespawn();
		forestRoom1.addNPC(new NPC(150, "Hey you look new around here! I can help you out! You can use A and D to move, and W to jump! You can jump over those platforms over there!"));
		forestRoom1.addPlatform(new Platform(500, 650));
		forestRoom1.addPlatform(new Platform(550, 600));
		forestRoom1.addPlatform(new Platform(600, 550));
		forestRoom1.start();

		Room forestRoom2 = new Room("Sky"); forestRoom1.setRespawn();
		forestRoom2.addNPC(new NPC(150, "Press SPACE to use your notebook! Type INVENTORY  and press ENTER to access your inventory! Try equiping some gear!"));
		forestRoom2.addPlatform(new Platform(500, 600));
		forestRoom2.addPlatform(new Platform(510, 510));
		forestRoom2.addPlatform(new Platform(520, 420));

		Room forestRoom3 = new Room("Sky");
		forestRoom3.addNPC(new NPC(150, "Watch out for traps! If you land in one, open your notebook and type ESCAPE! You take less damage from traps the more DEXTERITY you have!"));
		forestRoom3.addTrap(new Trap(500));
		forestRoom3.addNPC(new NPC(700, "Wow, looks like you may have taken some damage from that trap! Type HEAL in your notebook to cast a heal spell! Be careful, it uses mana!"));


//		forestRoom3.addPlatform(new Platform(475, 610));
//		forestRoom3.addPlatform(new Platform(525, 610));
//		forestRoom3.addChest(new Treasure(850, 650, 25));
//		forestRoom3.addPlatform(new Platform(575, 610));
//		forestRoom3.addPlatform(new Platform(625, 610));
//		forestRoom3.addEnemies(new Enemy(510, 400, "Robot", 2, 1));
//		forestRoom3.addEnemies(new Enemy(610, 300, "Robot", 2));

		Room forestRoom4 = new Room("Sky");
		forestRoom4.addNPC(new NPC(200, "Look! Theres a treasure chest! I'll let you get that one! Type OPEN or UNLOCK when you're right next to it to open it!"));
		forestRoom4.addChest(new Treasure(350, AdventureManager.floorHeight-50, 75));

		Room forestRoom5 = new Room("Sky");
		forestRoom5.addPlatform(new Platform(775, 400));
		forestRoom5.addPlatform(new Platform(675, 500));
		forestRoom5.addPlatform(new Platform(575, 600));
		forestRoom5.addPlatform(new Platform(665, 300));
		forestRoom5.addPlatform(new Platform(565, 200));
		forestRoom5.addPlatform(new Platform(300, 500));
		forestRoom5.addChest(new Treasure(300, 450, 100));
		forestRoom5.addNPC(new NPC(150, "Look! There is another treasure chest! See if you can get to that one!"));

		//Initialization of Non-Player Character with items to sell
		NPC warningGuy = new NPC(250, "Hey! I am a shopkeeper! if you have money, you can buy sweet items from me! Type SHOP into your notebook when stadning near me to buy from me!");
		warningGuy.addItem(new Item(
				"Cloth Armor",
				"Armor",
				"Not very strong. I mean realistically, it's as strong as you would anticipate cloth being.",
				10,
				5,
				5,
				0
				),50);
		warningGuy.addItem(new Item(
				"Leather Armor",
				"Armor",
				"Armor made out of leather. Tag says it's \"Not Vegan\"",
				20,
				10,
				0,
				10
				),100);
		warningGuy.addItem(new Item(
				"Weak Staff",
				"Weapon",
				"Mostly just a stick. Not many people would argue that it is hard to use.",
				10,
				5,
				5,
				0
				),50);
		warningGuy.addItem(new Item(
				"Shotty Bow",
				"Weapon",
				"Good if you can aim. If not, maybe apply for a job somewhere else.",
				20,
				10,
				0,
				10
				),100);
		warningGuy.addItem(new Item(
				"Apple",
				"Health Item",
				"Weakness of doctors",
				5
				),5);
		warningGuy.addItem(new Item(
				"Orange",
				"Health Item",
				"Orange you glad I didn't say apple?",
				10
				),20);
		warningGuy.addItem(new Item(
				"Berry",
				"Mana Item",
				"I would be berry glad if you bought this!",
				5
				),5);
		warningGuy.addItem(new Item(
				"Doubleberry",
				"Mana Item",
				"Double the berry flavor!",
				10
				),20);
		Room forestRoom6 = new Room("Sky"); forestRoom6.setRespawn();
		forestRoom6.addNPC(warningGuy);
		forestRoom6.addPlatform(new Platform(475, 610));
				forestRoom6.addPlatform(new Platform(525, 610));
				forestRoom6.addChest(new Treasure(850, 650, 25));
				forestRoom6.addPlatform(new Platform(575, 610));
				forestRoom6.addPlatform(new Platform(625, 610));

		Room forestRoom7 = new Room("Sky");
		forestRoom7.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Robot", 10, 2));
		forestRoom7.addNPC(new NPC(200, "Look out for those enemies! To block type BLOCK into your notebook, to use a basic attack type ATTACK and to cast a magic attack type FIREBALL, fireballs use mana though!"));

		Room caveRoom1 = new Room("Cave");
		caveRoom1.addNPC(new NPC(250, "Wow! These caves look very dangerous! Look out for those Magma Monsters!"));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 500, "Magma", 10));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Magma", 10));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 10));
		NPC caveGuy = new NPC(250, "Hey! I am a shopkeeper! if you have money, you can buy sweet items from me! Type SHOP into your notebook when standing near me to buy from me!");
		caveGuy.addItem(new Item(
				"Battle Armor",
				"Armor",
				"Armor ready for battling!",
				30,
				5,
				5,
				20
				),200);
		caveGuy.addItem(new Item(
				"Wizard Cloak",
				"Armor",
				"Looks very regal",
				20,
				5,
				20,
				5
				),200);
		caveGuy.addItem(new Item(
				"Battle Sword",
				"Weapon",
				"This is also mostly ready for battle!",
				30,
				5,
				5,
				20
				),200);
		caveGuy.addItem(new Item(
				"Iron Staff",
				"Weapon",
				"Metal stick. Enough said.",
				20,
				5,
				20,
				5
				),200);
		caveGuy.addItem(new Item(
				"Healing Potion",
				"Health Item",
				"Tastes like gatorade",
				20
				),40);
		caveGuy.addItem(new Item(
				"Great healing potion",
				"Health Item",
				"Tastes like superior gatorade",
				30
				),40);
		caveGuy.addItem(new Item(
				"Mana Potion",
				"Mana Item",
				"Tastes like blue gatorade",
				20
				),40);
		caveGuy.addItem(new Item(
				"Powerful mana potion",
				"Mana Item",
				"Tastes like POWERFUL gatorare",
				30
				),50);
		caveRoom1.addNPC(caveGuy);
		Room caveRoom2 = new Room("Cave");
		caveRoom2.addChest(new Treasure(650,150,100));
		caveRoom2.addPlatform(new Platform(150, 600));
		caveRoom2.addPlatform(new Platform(250, 500));
		caveRoom2.addPlatform(new Platform(350, 400));
		caveRoom2.addPlatform(new Platform(450, 300));
		caveRoom2.addPlatform(new Platform(550, 200));
		caveRoom2.addPlatform(new Platform(650, 200));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 12));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Magma", 12));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 12));

		Room caveRoom3 = new Room("Cave");
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 400, "Magma", 13));
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 500, "Magma", 13));
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 13));

		Room caveRoom4 = new Room("Cave");
		caveRoom4.addPlatform(new Platform(775, 400));
		caveRoom4.addPlatform(new Platform(675, 500));
		caveRoom4.addPlatform(new Platform(575, 600));
		caveRoom4.addPlatform(new Platform(665, 300));
		caveRoom4.addPlatform(new Platform(565, 200));
		caveRoom4.addPlatform(new Platform(135, 500));
		caveRoom4.addChest(new Treasure(135, 450, 250));


		Room caveRoom5 = new Room("Cave"); caveRoom5.setRespawn();

		Room caveRoom6 = new Room("Cave");
		caveRoom6.addNPC(new NPC(250, "This looks like the final Room in the caves! Look out, those monsters are strong!"));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 18));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Robot", 18));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 18));

		Room caveRoom7 = new Room("Sky");
		caveRoom7.addNPC(new NPC(250, "Yay, you made it out of the cave!"));
		caveRoom7.addNPC(new NPC(450, "Great job using your typing skills!"));
		caveRoom7.addNPC(new NPC(650, "I'm glad you made it out alive!"));
		caveRoom7.addChest(new Treasure(850, 650, 2500));
		caveRoom7.addChest(new Treasure(920, 650, 2500));
		caveRoom7.addChest(new Treasure(980, 650, 2500));
		caveRoom7.addChest(new Treasure(1050, 650, 2500));


		//Sets the different rooms to have rooms on their right and left
		forestRoom1.addRightRoom(forestRoom2);
		forestRoom2.addRightRoom(forestRoom3); forestRoom2.addLeftRoom(forestRoom1);
		forestRoom3.addLeftRoom(forestRoom2); forestRoom3.addRightRoom(forestRoom4);
		forestRoom4.addLeftRoom(forestRoom3); forestRoom4.addRightRoom(forestRoom5);
		forestRoom5.addLeftRoom(forestRoom4); forestRoom5.addRightRoom(forestRoom6);
		forestRoom6.addLeftRoom(forestRoom5); forestRoom6.addRightRoom(forestRoom7);
		forestRoom7.addLeftRoom(forestRoom6); forestRoom7.addRightRoom(caveRoom1);
		caveRoom1.addLeftRoom(forestRoom7); caveRoom1.addRightRoom(caveRoom2);
		caveRoom2.addLeftRoom(caveRoom1); caveRoom2.addRightRoom(caveRoom3);
		caveRoom3.addLeftRoom(caveRoom2); caveRoom3.addRightRoom(caveRoom4);
		caveRoom4.addLeftRoom(caveRoom3);caveRoom4.addRightRoom(caveRoom5);
		caveRoom5.addLeftRoom(caveRoom4); caveRoom5.addRightRoom(caveRoom6);
		caveRoom6.addLeftRoom(caveRoom5); caveRoom6.addRightRoom(caveRoom7);
		caveRoom7.addLeftRoom(caveRoom6);
	}






	/*This method creates the space that the rooms and characters will be represented within.
	 *@Param none
	 *@returns none
	 * */
	public void createSpace() {

		toon = new Adventurer(floorHeight, 0); //Creates a new Adventurer
		mainPanel = new JLabel(); //Creates the panel that everything will be added to.
		mainPanel.setSize(1194, 771);
		mainPanel.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.MAGENTA);
		Main.window.add(mainPanel);
		mainPanel.setIcon(background);
		n = new Notepad();

		mainPanel.add(toon);
		Main.window.addKeyListener(toon);

		dataPanel = new JPanel();
		dataPanel.setLocation(0, 0);
		dataPanel.setSize(1200, 30);
		dataPanel.setLayout(null);
		dataPanel.setBackground(Color.cyan);
		mainPanel.add(dataPanel);

		healthInfo = new JLabel(); //Displays health and stats (Soon)
			AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
		healthInfo.setSize(1200,25);
		healthInfo.setLocation(0,0);
		healthInfo.setFont(GUIFont);
		dataPanel.add(healthInfo);

		floor = new JPanel(); //Its the floor
		floor.setLocation(0, floorHeight);
		floor.setSize(1200, 300);
		floor.setBackground(Color.gray);
		mainPanel.add(floor);

		mainPanel.setVisible(true);
		Main.window.setVisible(true);
		floor.setVisible(true);

		lossPanel = new JPanel(); //Creates the panel that is displayed when the player loses (dies)
		lossPanel.setSize(1194, 771);
		lossPanel.setLayout(null);
		lossPanel.setLocation(0,0);
		lossPanel.setBackground(Color.black);
		JPanel lossTextPanel = new JPanel();
		lossTextPanel.setSize(600,250);
		lossTextPanel.setLocation(297, 100);
		lossTextPanel.setBackground(Color.black);
		lossTextPanel.setLayout(new GridLayout(1,1));
		lossPanel.add(lossTextPanel);


		JTextArea lossArea = new JTextArea();
		lossArea.setBackground(Color.black);
		lossArea.setForeground(Color.WHITE);
		lossArea.setFont(TextFont);
		lossArea.setLineWrap(true);
		lossArea.setWrapStyleWord(true);
		lossArea.setEditable(false);
		lossArea.setText("Looks like you lost! Don't worry, if you try hard you can win next time!");
		lossTextPanel.add(lossArea);

		JPanel  darnPanel = new JPanel();
		darnPanel.setSize(150,50);
		darnPanel.setLocation(500, 500);
		darnPanel.setBackground(Color.red);
		darnPanel.setLayout(new GridLayout(1,1));
		lossPanel.add(darnPanel);

		JButton darnButton = new JButton();
		darnButton.setFont(GUIFont);
		darnButton.setFocusPainted(false);
		darnButton.setText("Oh Darn!");
		darnButton.setBackground(Color.WHITE);
		darnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) { //Actionlistener for when the player click the "oh darn" button!
				lossPanel.setVisible(false);
				Adventurer.health = Adventurer.maxHealth;
				Adventurer.mana = Adventurer.maxMana;
					AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
				AdventureManager.mainPanel.setVisible(true);
				Main.window.requestFocus();
			}
		});
		darnPanel.add(darnButton);

		lossPanel.setVisible(false);
		Main.window.add(lossPanel);

		createWorld(); //Calls the create world method which actually makes the different rooms
	}
	/*This method heals the player, making sure their health does not go above their maximum health
	 *@Param h is the amount to heal the player with
	 *@returns none
	 * */
	static void heal(int h) {
		Adventurer.health += h;
		if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
		healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + gold );

	}

}
