import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ForceField extends JLabel{
    int hits = Adventurer.strength;
    int x, y;

    /*
  Constructor for the shield
    @Param none
    @Return none
    */
	ForceField(){

          setSize(60,110);
          AdventureManager.mainPanel.add(this);
          setVisible(true);

      }
      /*
      Checks to the direction that the player is facing and faces the same way
      @Param none
      @Return none
      */
     public void update(){
    	 ImageIcon block;
    	 if(AdventureManager.toon.direction.equals("left")) {
           block = new ImageIcon(getClass().getClassLoader().getResource("ShieldgoodLeft.png"));
           setIcon(block);
           setIcon(block);
           x = AdventureManager.toon.x - 50;
           y =  AdventureManager.toon.y-5;
           setLocation(x,y);

       }
    	 if(AdventureManager.toon.direction.equals("right")) {
             block = new ImageIcon(getClass().getClassLoader().getResource("ShieldgoodRight.png"));
             setIcon(block);
             x = AdventureManager.toon.x + 50;
             y =  AdventureManager.toon.y-5;
             setLocation(x,y);}

             /*
          Checks for collision with enemy projectiles
             */
    	 for(int i = 0; i < AdventureManager.currentRoom.enemyProjectiles.size(); i++){
 			if(((AdventureManager.currentRoom.enemyProjectiles.get(i).x + 50 > x) && (AdventureManager.currentRoom.enemyProjectiles.get(i).x + 50 < x+50) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50< y+98) )
 					|| ((AdventureManager.currentRoom.enemyProjectiles.get(i).x > x) && (AdventureManager.currentRoom.enemyProjectiles.get(i).x < x+50)  &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50> y) &&(AdventureManager.currentRoom.enemyProjectiles.get(i).y + 50< y+98) )

 						) {

 					hits--;
 					AdventureManager.currentRoom.enemyProjectiles.get(i).kill();

 				}
 		}
    	//If the shield has no health destroy it
        if(hits <= 0) { AdventureManager.currentRoom.fields.remove(this);   this.setVisible(false);}

      }
}
