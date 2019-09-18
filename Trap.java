import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Trap extends JLabel{
  //initialization of variables
  int x;
  int count = 0;

  //Constructor for the Trap class
  Trap(int x){
    //initialize position
    this.x = x;
    //place on screen without displaying
	  setSize(100,50);
    setLocation(this.x, AdventureManager.floorHeight-50);
    setIcon(new ImageIcon(getClass().getClassLoader().getResource("Trap.png")));
    AdventureManager.mainPanel.add(this);
    setVisible(false);
  }

/*
Update function for the trap objects
@Param: none
@Return: none
*/
  public void update(){
    //makes the trap visible if player is within the trap and does damage based on the count variable
	  if(((AdventureManager.toon.x + 25  > x) && (AdventureManager.toon.x + 25  < x + 100))
				) {
			setVisible(true);
			repaint();
			AdventureManager.currentTrap = this;
			restrictMovement();
			doDamage();
		}
	  else {
		  if(AdventureManager.currentTrap != null) AdventureManager.currentTrap = null;
	  }
  }

/*
Method to restrict the player's movement when caught in a trap
@Param: none
@Return: none
*/
  public void restrictMovement() {
    //disables jumping for the player
	 AdventureManager.toon.cantJump = true;

   //Restricts all player movement to the confines of the trap
	  if(AdventureManager.toon.x < x) {
		  AdventureManager.toon.x = x;
		  AdventureManager.toon.setLocation(AdventureManager.toon.x, AdventureManager.toon.y);
		  AdventureManager.mainPanel.repaint();
	  }
	  if(AdventureManager.toon.x + 50 > x+100) {
		  AdventureManager.toon.x = x+50;
		  AdventureManager.toon.setLocation(AdventureManager.toon.x, AdventureManager.toon.y);
		  AdventureManager.mainPanel.repaint();
	  }
  }

  /*
  The damage method for traps
  @Param: none
  @Return: none
  */
  public void doDamage() {
    //damages the player every time the count variable reaches 0
	  if(count <= 0) { AdventureManager.toon.damage(2);  count = 100 + Adventurer.dexterity*5;}
	  else count--;
  }

  /*
  Kills the trap
  @Param: none
  @Return: none
  */
  public void kill() {
	  AdventureManager.currentRoom.traps.remove(this);
	  AdventureManager.toon.cantJump = false;
	  setVisible(false);
  }
}
