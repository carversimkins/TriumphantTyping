import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Treasure extends JLabel{
	private boolean open;
	 int gold , x , y, locksPassed = 0, locksFailed = 0;
	 JPanel unlockPanel;
	int count;
	/*
	Constructor for the trasure chest
	@Param int x1 is the x value for the chest
	@Param int y1 is the y value for the trasure chest
	@Param int g is the amount of gold given to the opener
	*/
	Treasure(int x1, int y1, int g){
		setIcon(new ImageIcon(getClass().getClassLoader().getResource("Chest.png")));
		x = x1;
		y = y1;
		setSize(50,50);
		setLocation(x,y);
		open = false;
		gold = g;
	}
	/*
Opens the chest
	*/
	public void openChest(){
		open = true;
		 AdventureManager.gold += AdventureManager.currentTreasure.gold;
	 	AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold  + "    Mana: " + Adventurer.mana + "/" + Adventurer.maxMana );
		setIcon(new ImageIcon(getClass().getClassLoader().getResource("ChestOpen.png")));


	}
	/*
Opens the chest
	*/
	public void update() {
		if((open==false) && ((AdventureManager.toon.x + 50 > x) && (AdventureManager.toon.x + 50 < x+50) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )
				|| ((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50)  && (open==false) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )

					) {
				AdventureManager.currentTreasure = this;
				if(count == 0) count++;
			}
		else {
			if(count>0) {
				AdventureManager.currentTreasure = null;
				count = 0;
			}
		}

	}

}
