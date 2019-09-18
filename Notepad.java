import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Notepad extends JLabel{
	//Initialization of variables
	static String word = "";
	Font font;
	static ArrayList<String> letters = new ArrayList<String>();
	Boolean on = false;
	JTextArea area, wordAttack;
	Random rand = new Random();
	JPanel panel;
	static Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);

	Notepad(){
		ImageIcon block;
		block = new ImageIcon(getClass().getClassLoader().getResource("NotebookGood.png"));
		setIcon(block);
		setSize(200, 30);
		setVisible(false);
		 area = new JTextArea();
		 area.setLineWrap(true);
		 area.setWrapStyleWord(true);
		area.setFont(buttonFont);
		area.setSize(200,30);
		area.setLocation(0,0);
		area.setOpaque(false);
		area.setEditable(false);
		add(area);
		AdventureManager.mainPanel.add(this);

	}
	/*
	Method to show the notepad
	@Param: none
	@Return: none
	*/
	public void showPad(){
AdventureManager.currentRoom.t.setDelay(50);
		//Main.window.removeKeyListener(AdventureManager.toon);
		on = true;
		setVisible(true);
	}
	public void hidePad() {
		//Main.window.addKeyListener(AdventureManager.toon);
		on = false;
		setVisible(false);
		Main.window.requestFocus();
		AdventureManager.currentRoom.t.setDelay(5);
	}

	/*
	Method to update the word typed in the notepad
	@Param: none
	@Return: none
	*/
	public void updateWord(){
		word = "";
		for(int i = 0; i < letters.size(); i++) {
			word = word + letters.get(i);

		}
		area.setText(word);
	}

	/*
	Method that runs code depending on the word submitted in the notepad
	@Param: none
	@Return: none
	*/
	public void submitWord(){
		if(word.equals("fireball")){
			fireball();
		}
		if(word.equals("inventory")){
			Adventurer.inven.open();
		}
		if(word.equals("shop") && (AdventureManager.currentNPC != null)){
		 AdventureManager.shop.openShop();
		}
		if(word.equals("block") && AdventureManager.currentRoom.fields.isEmpty()){
			AdventureManager.currentRoom.fields.add(new ForceField());
		}
		if(word.equals("attack")){
			AdventureManager.currentRoom.projectiles.add(new Projectile(AdventureManager.toon.x, AdventureManager.toon.y, AdventureManager.toon.direction, 5, "sword"));
		}
		if(word.equals("unlock") || word.equals("open") || word.equals("treasure")){
			if(AdventureManager.currentTreasure != null) {
 		 AdventureManager.currentTreasure.openChest();
 			Main.window.setVisible(true);
 		 }
		}
		if(word.equals("heal")){
		heal();
		}
		if(word.equals("escape") && (AdventureManager.currentTrap != null)){
			AdventureManager.currentTrap.kill();
			}


	}

	/*
	Method to launch a fireball
	@Param: none
	@Return: none
	*/
	public void fireball(){
		if(Adventurer.mana >= 2) {
			AdventureManager.currentRoom.projectiles.add(new Projectile(AdventureManager.toon.x, AdventureManager.toon.y, AdventureManager.toon.direction, 3, "fireball"));
			AdventureManager.toon.costmana(1);
		}
	}

	/*
	Method to heal the player
	@Param: none
	@Return: none
	*/
	public void heal(){
	if(Adventurer.mana>=3) {
		Adventurer.health += AdventureManager.toon.intelligence;
		if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
		AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
		AdventureManager.toon.costmana(3);
	}
	}

	/*
	Update method to keep the notepad above the player
	@Param: none
	@Return: none
	*/
	public void Update(){
		setLocation(AdventureManager.toon.x-75, AdventureManager.toon.y-70);
	}
}
