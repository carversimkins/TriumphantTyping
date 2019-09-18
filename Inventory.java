import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Inventory{

	//Declaring the extrememly uneccessary amount of variables within this class
	JLabel inventoryPanel = new JLabel();
	ImageIcon inventoryB = new ImageIcon(getClass().getClassLoader().getResource("InventoryImage.png"));;
	static boolean on;
	int currentItem;
	Item currentWeapon;
	boolean equipedArmor = false;
	boolean equipedWeapon = false;
	Item currentArmor;
//Declaring the very important buttons
	static JButton iButton1 = new JButton(),
			iButton2 = new JButton(),
			iButton3 = new JButton(),
			iButton4 = new JButton(),
			iButton5 = new JButton(),
			iButton6 = new JButton(),
			iButton7 = new JButton(),
			iButton8 = new JButton(),
			iButton9 = new JButton(),
			iButton10 = new JButton(),
			iButton11 = new JButton(),
			iButton12 = new JButton(),
			dropButton = new JButton(),
			useButton = new JButton();

	JTextArea infoArea;
	JPanel usePanel;
	static Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
	static ArrayList<Item> items = new ArrayList<Item>(12);
	/*
Creates the inventory!
	@Param none
	@Return none
	*/
 public Inventory() {

	 //Setting size and location of the different elements within the inventory
		inventoryPanel.setSize(1194, 771);
		inventoryPanel.setIcon(inventoryB);
		inventoryPanel.setLocation(0,0);
		inventoryPanel.setLayout(null);
		inventoryPanel.setBackground(Color.green);
		Main.window.add(inventoryPanel);
		inventoryPanel.setVisible(false);
		Main.window.setVisible(true);

		on = true;


		JButton leaveButton = new JButton("Exit");

		leaveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			inventoryPanel.setVisible(false);
			 AdventureManager.mainPanel.setVisible(true);
				 AdventureManager.currentRoom.t.start();
					Main.window.requestFocus();
			}

		});
		leaveButton.setSize(100, 50);
		leaveButton.setLocation(1090, 715);
		leaveButton.setBackground(Color.yellow);
		inventoryPanel.add(leaveButton);
		leaveButton.setVisible(true);


		JPanel holderPanel = new JPanel();
		holderPanel.setLocation(50, 150);
		holderPanel.setSize(500,550);
		holderPanel.setBackground(Color.blue);
		holderPanel.setLayout(new GridLayout(6,2));
		holderPanel.setOpaque(false);
		inventoryPanel.add(holderPanel);


		/*
		Creating all the individual buttons and adding most of the fucntionality
		*/
		iButton1.setBackground(Color.cyan);
		iButton1.setFocusPainted(false);
		iButton1.setFont(buttonFont);
		iButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 0;
				updateInfo();
			}
		});
		holderPanel.add(iButton1);


		iButton2.setBackground(Color.cyan);
		iButton2.setFocusPainted(false);
		iButton2.setFont(buttonFont);
		iButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 1;
				updateInfo();
			}
		});
		holderPanel.add(iButton2);

		iButton3.setBackground(Color.cyan);
		iButton3.setFocusPainted(false);
		iButton3.setFont(buttonFont);
		iButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 2;
				updateInfo();
			}
		});
		holderPanel.add(iButton3);

		iButton4.setBackground(Color.cyan);
		iButton4.setFocusPainted(false);
		iButton4.setFont(buttonFont);
		iButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 3;
				updateInfo();
			}
		});
		holderPanel.add(iButton4);

		iButton5.setBackground(Color.cyan);
		iButton5.setFocusPainted(false);
		iButton5.setFont(buttonFont);
		iButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 4;
				updateInfo();
			}
		});
		holderPanel.add(iButton5);

		iButton6.setBackground(Color.cyan);
		iButton6.setFocusPainted(false);
		iButton6.setFont(buttonFont);
		iButton6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 5;
				updateInfo();
			}
		});
		holderPanel.add(iButton6);

		iButton7.setBackground(Color.cyan);
		iButton7.setFocusPainted(false);
		iButton7.setFont(buttonFont);
		iButton7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 6;
				updateInfo();
			}
		});
		holderPanel.add(iButton7);

		iButton8.setBackground(Color.cyan);
		iButton8.setFocusPainted(false);
		iButton8.setFont(buttonFont);
		iButton8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 7;
				updateInfo();
			}
		});
		holderPanel.add(iButton8);

		iButton9.setBackground(Color.cyan);
		iButton9.setFocusPainted(false);
		iButton9.setFont(buttonFont);
		iButton9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 8;
				updateInfo();
			}
		});
		holderPanel.add(iButton9);

		iButton10.setBackground(Color.cyan);
		iButton10.setFocusPainted(false);
		iButton10.setFont(buttonFont);
		iButton10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 9;
				updateInfo();
			}
		});
		holderPanel.add(iButton10);

		iButton11.setBackground(Color.cyan);
		iButton11.setFocusPainted(false);
		iButton11.setFont(buttonFont);
		iButton11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 10;
				updateInfo();
			}
		});
		holderPanel.add(iButton11);

		iButton12.setBackground(Color.cyan);
		iButton12.setFocusPainted(false);
		iButton12.setFont(buttonFont);
		iButton12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentItem = 11;
				updateInfo();
			}
		});
		holderPanel.add(iButton12);


		JPanel infoPanel = new JPanel();
		infoPanel.setLocation(600, 150);
		infoPanel.setSize(500,550);
		infoPanel.setBackground(Color.green);
		infoPanel.setLayout(null);
		inventoryPanel.add(infoPanel);

		infoArea = new JTextArea();
		infoArea.setLineWrap(true);
		infoArea.setLocation(0,0);
		infoArea.setSize(500,550);
		infoArea.setWrapStyleWord(true);
		infoArea.setEditable(false);
		infoArea.setFont(buttonFont);
		infoPanel.add(infoArea);

		usePanel = new JPanel();
		usePanel.setLocation(200, 425);
		usePanel.setSize(100,100);
		usePanel.setBackground(Color.BLACK);
		usePanel.setVisible(true);
		usePanel.setLayout(new GridLayout(2,1));
		infoArea.add(usePanel);

		usePanel.add(useButton);
		useButton.setFocusPainted(false);
		dropButton.setFocusPainted(false);
		usePanel.setVisible(false);
		useButton.setBackground(Color.green);
		dropButton.setBackground(Color.red);
		usePanel.add(dropButton);


		/*
		Drops the item currently selected and adjusts stats accordingly
		*/
		dropButton.addActionListener(new ActionListener() {

			/*
			This method unequips an equipped item
			@Param: ActionEvent with action key
			@Return: none
			*/
			@Override
			public void actionPerformed(ActionEvent e) {
				if(items.get(currentItem) == currentWeapon){
					Adventurer.strength -= items.get(currentItem).strength;
						Adventurer.dexterity -= items.get(currentItem).dexterity;
							Adventurer.intelligence -= items.get(currentItem).intelligence;
								Adventurer.vitality -= items.get(currentItem).vitality;
								 Adventurer.maxHealth = 20 + Adventurer.vitality;
								 Adventurer.maxMana = 10 + Adventurer.intelligence;
								 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
								 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
				}
				if(items.get(currentItem) == currentArmor){
					Adventurer.strength -= items.get(currentItem).strength;
						Adventurer.dexterity -= items.get(currentItem).dexterity;
							Adventurer.intelligence -= items.get(currentItem).intelligence;
								Adventurer.vitality -= items.get(currentItem).vitality;
								 Adventurer.maxHealth = 20 + Adventurer.vitality;
								 Adventurer.maxMana = 10 + Adventurer.intelligence;
								 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
								 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
				}
				items.remove(currentItem);
				updateInfo();

			}
		});


		useButton.addActionListener(new ActionListener() {

			/*
			Performs a different action depending on the item used.
			@Param: ActionEvent input to determine keypress
			@Return: none
			*/
			@Override
			public void actionPerformed(ActionEvent e) {
				if(items.get(currentItem).type.equals("Health Item")) {
					AdventureManager.heal(items.get(currentItem).value);
					items.remove(currentItem);
					updateInfo();
				}
				if(items.get(currentItem).type.equals("Mana Item")) {
					Adventurer.costmana(-items.get(currentItem).value);
					items.remove(currentItem);
					updateInfo();
				}
				else if(items.get(currentItem).type == "Weapon") {
					equipWeapon(items.get(currentItem));
					updateInfo();
				}
				else if(items.get(currentItem).type.equals("Armor")) {
					equipArmor(items.get(currentItem));
					updateInfo();
				}

			}
		});

		holderPanel.setVisible(true);


 }
 /*
 Every time a button is pushed, all the buttons need to be updated using the new data, this is the method that does that.
 @Param none
 @Return none
 */
 public void updateInfo() {


	 if(items.size() > 0) iButton1.setText(items.get(0).name); else iButton1.setText(""); if((items.size() > 0) && ((items.get(0)==(currentArmor)) || (items.get(0).equals(currentWeapon)))) iButton1.setBackground(Color.green); else iButton1.setBackground(Color.cyan);
		if(items.size() > 1) iButton2.setText(items.get(1).name); else iButton2.setText(""); if((items.size() > 1) && ((items.get(1)==(currentArmor)) || (items.get(1).equals(currentWeapon)))) iButton2.setBackground(Color.green); else iButton2.setBackground(Color.cyan);
		if(items.size() > 2) iButton3.setText(items.get(2).name); else iButton3.setText(""); if((items.size() > 2) && ((items.get(2)==(currentArmor)) || (items.get(2).equals(currentWeapon)))) iButton3.setBackground(Color.green); else iButton3.setBackground(Color.cyan);
		if(items.size() > 3) iButton4.setText(items.get(3).name); else iButton4.setText(""); if((items.size() > 3) && ((items.get(3).equals(currentArmor)) || (items.get(3).equals(currentWeapon)))) iButton4.setBackground(Color.green); else iButton4.setBackground(Color.cyan);
		if(items.size() > 4) iButton5.setText(items.get(4).name); else iButton5.setText(""); if((items.size() > 4) && ((items.get(4).equals(currentArmor)) || (items.get(4).equals(currentWeapon)))) iButton5.setBackground(Color.green); else iButton5.setBackground(Color.cyan);
		if(items.size() > 5) iButton6.setText(items.get(5).name); else iButton6.setText(""); if((items.size() > 5) && ((items.get(5).equals(currentArmor)) || (items.get(5).equals(currentWeapon)))) iButton6.setBackground(Color.green); else iButton6.setBackground(Color.cyan);
		if(items.size() > 6) iButton7.setText(items.get(6).name); else iButton7.setText(""); if((items.size() > 6) && ((items.get(6).equals(currentArmor)) || (items.get(6).equals(currentWeapon)))) iButton7.setBackground(Color.green); else iButton7.setBackground(Color.cyan);
		if(items.size() > 7) iButton8.setText(items.get(7).name); else iButton8.setText(""); if((items.size() > 7) && ((items.get(7).equals(currentArmor)) || (items.get(7).equals(currentWeapon)))) iButton8.setBackground(Color.green); else iButton8.setBackground(Color.cyan);
		if(items.size() > 8) iButton9.setText(items.get(8).name); else iButton9.setText(""); if((items.size() > 8) && ((items.get(8).equals(currentArmor)) || (items.get(8).equals(currentWeapon)))) iButton9.setBackground(Color.green); else iButton9.setBackground(Color.cyan);
	  if(items.size() > 9) iButton10.setText(items.get(9).name); else iButton10.setText(""); if((items.size() > 9) && ((items.get(9).equals(currentArmor)) || (items.get(9).equals(currentWeapon)))) iButton10.setBackground(Color.green); else iButton10.setBackground(Color.cyan);
	if(items.size() > 10) iButton11.setText(items.get(10).name); else iButton11.setText(""); if((items.size() > 10) && ((items.get(10).equals(currentArmor)) || (items.get(10).equals(currentWeapon)))) iButton11.setBackground(Color.green); else iButton11.setBackground(Color.cyan);
	if(items.size() > 11) iButton12.setText(items.get(11).name); else iButton12.setText("");  if((items.size() > 11) && ((items.get(11).equals(currentArmor)) || (items.get(11).equals(currentWeapon)))) iButton12.setBackground(Color.green); else iButton12.setBackground(Color.cyan);


		equipedArmor = false;
		equipedWeapon=false;
		for(int i = 0; i<items.size(); i++) {
			if(items.get(i).equals(currentArmor)) equipedArmor=true;
			if(items.get(i).equals(currentWeapon)) equipedWeapon=true;
		}
//		if(equipedArmor == false) {
//			Adventurer.maxHealth = 20;
//			 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold ); + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
//		}


	 if(currentItem>=items.size()) {
		infoArea.setText("This is an empty space!");
		usePanel.setVisible(false);




	 }
	 else {


		 	if(items.get(currentItem).type.equals("Health Item")) {
				infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description + "\n\nHeals by " + items.get(currentItem).value + " health!");
				usePanel.setVisible(true);
				useButton.setText("Use");
				dropButton.setText("Drop");
		 	}
		 	if(items.get(currentItem).type.equals("Mana Item")) {
				infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description + "\n\nHeals by " + items.get(currentItem).value + " mana!");
				usePanel.setVisible(true);
				useButton.setText("Use");
				dropButton.setText("Drop");
		 	}
			if(items.get(currentItem).type.equals("Weapon")) {
				infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description +
						"\n\nStrength: " + items.get(currentItem).strength
						+ "\nDexterity: " + items.get(currentItem).dexterity
				+ "\nIntelligence: " + items.get(currentItem).intelligence
				+ "\nVitality: " + items.get(currentItem).vitality);
				usePanel.setVisible(true);
				useButton.setText("Equip");
				dropButton.setText("Drop");
			}
			if(items.get(currentItem).type.equals("Armor")) {
				infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description +
						"\n\nStrength: " + items.get(currentItem).strength
						+ "\nDexterity: " + items.get(currentItem).dexterity
				+ "\nIntelligence: " + items.get(currentItem).intelligence
				+ "\nVitality: " + items.get(currentItem).vitality);
				usePanel.setVisible(true);
				useButton.setText("Equip");
				dropButton.setText("Drop");
			}

	 }


	 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
	 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
 }

 static void addItem(Item t) {
	 items.add(t);
	    if(items.size() > 0) iButton1.setText(items.get(0).name); else iButton1.setText("");
		if(items.size() > 1) iButton2.setText(items.get(1).name); else iButton2.setText("");
		if(items.size() > 2) iButton3.setText(items.get(2).name); else iButton3.setText("");
		if(items.size() > 3) iButton4.setText(items.get(3).name); else iButton4.setText("");
		if(items.size() > 4) iButton5.setText(items.get(4).name); else iButton5.setText("");
		if(items.size() > 5) iButton6.setText(items.get(5).name); else iButton6.setText("");
		if(items.size() > 6) iButton7.setText(items.get(6).name); else iButton7.setText("");
		if(items.size() > 7) iButton8.setText(items.get(7).name); else iButton8.setText("");
		if(items.size() > 8) iButton9.setText(items.get(8).name); else iButton9.setText("");
		if(items.size() > 9) iButton10.setText(items.get(9).name); else iButton10.setText("");
		if(items.size() > 10) iButton11.setText(items.get(10).name); else iButton11.setText("");
		if(items.size() > 11) iButton12.setText(items.get(11).name); else iButton12.setText("");

 }
 /*
Opens the inventory
 @Param none
 @Return none
 */
 public void open() {

	 AdventureManager.currentRoom.t.stop();
	 updateInfo();
	inventoryPanel.setVisible(true);
	AdventureManager.mainPanel.setVisible(false);

 }
 /*
 Equips a weapon and adjusts stats accordingly
 @Param Item t is the weapon equipped
 @Return none
 */
 public void equipWeapon(Item t) {
	if(currentWeapon != null) { Adventurer.strength -= currentWeapon.strength; //Setting stats
		Adventurer.dexterity -= currentWeapon.dexterity;
		Adventurer.intelligence -= currentWeapon.intelligence;
		Adventurer.vitality -= currentWeapon.vitality;
		 Adventurer.maxHealth = 20 + Adventurer.vitality;
		  Adventurer.maxMana = 10 + Adventurer.intelligence;
		 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
		 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
	}
	 currentWeapon = t;
	 Adventurer.strength += t.strength;
	  Adventurer.dexterity += t.dexterity;
		Adventurer.intelligence += t.intelligence;
	 Adventurer.vitality += t.vitality;
	 Adventurer.maxHealth = 20 + Adventurer.vitality;
	  Adventurer.maxMana = 10 + Adventurer.intelligence;
	 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
 }
 /*
 Equip some armor
 @Param Item t is the armor equiped
 @Return none
 */
public void equipArmor(Item t) {
	if(currentArmor != null){
		Adventurer.strength -= currentArmor.strength; //Setting stats
	 	Adventurer.dexterity -= currentArmor.dexterity;
	 	Adventurer.intelligence -= currentArmor.intelligence;
	 	Adventurer.vitality -= currentArmor.vitality;
		 Adventurer.maxHealth = 20 + Adventurer.vitality;
		 Adventurer.maxMana = 10 + Adventurer.intelligence;
		 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
		 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
	}
	 currentArmor = t;
	 Adventurer.strength += t.strength;
	  Adventurer.dexterity += t.dexterity;
		Adventurer.intelligence += t.intelligence;
		 Adventurer.vitality += t.vitality;
		 Adventurer.maxHealth = 20 + Adventurer.vitality;
		 Adventurer.maxMana = 10 + Adventurer.intelligence;
	 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
}}
