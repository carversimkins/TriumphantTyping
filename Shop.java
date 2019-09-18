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

public class Shop {
	//initialize all variables for Shop
	JLabel shopPanel = new JLabel();
	ImageIcon inventoryB = new ImageIcon(getClass().getClassLoader().getResource("Shop.png"));;
	static boolean on;
	int currentItem;
	Item currentWeapon;
	boolean equipedArmor = false;
	boolean equipedWeapon = false;
	Item currentArmor;

	static JButton iButton1 = new JButton(),
			iButton2= new JButton(),
			iButton3= new JButton(),
			iButton4= new JButton(),
			iButton5= new JButton(),
			iButton6= new JButton(),
			iButton7= new JButton(),
			iButton8= new JButton(),
			iButton9= new JButton(),
			iButton10= new JButton(),
			iButton11= new JButton(),
			iButton12= new JButton(),

			buyButton = new JButton();

	JTextArea infoArea;
	JPanel usePanel;
	static Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
	static ArrayList<Item> items = new ArrayList<Item>(12);

//Constructor for Shop class
	Shop(){
		shopPanel.setSize(1194, 771);
		shopPanel.setIcon(inventoryB);
		shopPanel.setLocation(0,0);
		shopPanel.setLayout(null);
		shopPanel.setBackground(Color.green);
		Main.window.add(shopPanel);
		shopPanel.setVisible(false);
		Main.window.setVisible(true);

		on = true;


		JButton leaveButton = new JButton("Exit");

		leaveButton.addActionListener(new ActionListener() {

			/*
			Sets the shop to note visible and sets the main room to visible
			@Param: none
			@Return: none
			*/
			@Override
			public void actionPerformed(ActionEvent arg0) {


				shopPanel.setVisible(false);
				AdventureManager.mainPanel.setVisible(true);
				 AdventureManager.currentRoom.t.start();
					Main.window.requestFocus();
			}

		});
		//Creating the leave button
		leaveButton.setSize(100, 50);
		leaveButton.setLocation(1090, 715);
		leaveButton.setBackground(Color.red);
		shopPanel.add(leaveButton);
		leaveButton.setVisible(true);

		/*
		Creating the layout
		*/
		JPanel holderPanel = new JPanel();
		holderPanel.setLocation(50, 150);
		holderPanel.setSize(500,550);
		holderPanel.setBackground(Color.blue);
		holderPanel.setLayout(new GridLayout(6,2));
		holderPanel.setOpaque(false);
		shopPanel.add(holderPanel);

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
		shopPanel.add(infoPanel);

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
		usePanel.setLayout(new GridLayout(1,1));
		infoArea.add(usePanel);

		usePanel.add(buyButton);
		buyButton.setFocusPainted(false);

		usePanel.setVisible(false);
		buyButton.setBackground(Color.green);








		buyButton.addActionListener(new ActionListener() {

			/*
			Method for purchasing items with gold
			@Param: ActionEvent e for the button press
			@Return: none1
			*/
			@Override
			public void actionPerformed(ActionEvent e) {
				if((AdventureManager.gold >= items.get(currentItem).price)&&(Inventory.items.size()<12)) {
					Inventory.addItem(items.get(currentItem));
					AdventureManager.gold -= items.get(currentItem).price;
					AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold );

				}



				updateInfo();

			}
		});

		holderPanel.setVisible(true);


		}




		/*
		Makes the shop visible
		@Param: none
		@Return: none
		*/
		public void openShop(){
			AdventureManager.currentRoom.t.stop();

			shopPanel.setVisible(true);
			items = AdventureManager.currentNPC.shop;
			updateInfo();

		}

		/*
		Makes the shop not visible
		@Param: none
		@Return: none
		*/
		public void closeShop() {
			AdventureManager.currentRoom.t.start();
			shopPanel.setVisible(false);
		}

		//updates all the info forthe various buttons for the shop
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


			//If the space is empty
			 if(currentItem>=items.size()) {
				infoArea.setText("This is an empty space!");
				usePanel.setVisible(false);




			 }
			 //if the space has something in it, how to display
			 else {

				 if(items.get(currentItem).type.equals("Health Item")) {
						infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description + "\n\nHeals by " + items.get(currentItem).value + " health!" +

					"\n\nCosts " + items.get(currentItem).price + " gold!");
						usePanel.setVisible(true);
				 	}
				 if(items.get(currentItem).type.equals("Mana Item")) {
						infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description + "\n\nHeals by " + items.get(currentItem).value + " mana!" +

					"\n\nCosts " + items.get(currentItem).price + " gold!");
						usePanel.setVisible(true);
				 	}

					if(items.get(currentItem).type.equals("Weapon")) {
						infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description +
								"\n\nStrength: " + items.get(currentItem).strength
								+ "\nDexterity: " + items.get(currentItem).dexterity
						+ "\nIntelligence: " + items.get(currentItem).intelligence
						+ "\nVitality: " + items.get(currentItem).vitality
						+ "\n\nCosts " + items.get(currentItem).price + " gold!");

					}
					if(items.get(currentItem).type.equals("Armor")) {
						infoArea.setText(items.get(currentItem).name + "\n\n" + items.get(currentItem).type + "\n\n" + items.get(currentItem).description +
								"\n\nStrength: " + items.get(currentItem).strength
								+ "\nDexterity: " + items.get(currentItem).dexterity
						+ "\nIntelligence: " + items.get(currentItem).intelligence
						+ "\nVitality: " + items.get(currentItem).vitality
						+ "\n\nCosts " + items.get(currentItem).price + " gold!");
						usePanel.setVisible(true);
					}

						usePanel.setVisible(true);
						buyButton.setText("Buy");

						if(AdventureManager.gold < items.get(currentItem).price) buyButton.setBackground(Color.red);
						else buyButton.setBackground(Color.green);

			 }


			 if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
			 AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold );
		 }
}
