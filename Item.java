import java.util.Random;
public class Item {
  //Declaring the various variables used within the Item class
 String name, type, description;
 int value, price;
 int strength, dexterity, intelligence, vitality;
 Random rand = new Random();
 int id;
 String addStat;
 /*
 Constructor for items that simply add to a value like health or mana
 @Param n is the name
 @Param String t is the type of item
 @Param String d is the description of the item
 @Param String v is the value being added to health or mana
 @Return none
 */
 Item(String n, String t, String d, int v){
	 name = n;
	 type = t;
	 description = d;
	 value = v;
 }
 /*
 Constructor for items that are equipped
 @Param n is the name
 @Param String t is the type of item
 @Param String d is the description of the item
 @Param Int vitlity is how much vitality is added from the item
  @Param Int dexterity is how much dexterity is added from the item
   @Param Int intelligence is how much intelligence is added from the item
    @Param Int strength is how much strength is added from the item 
 @Return none
 */
 Item(String n, String t, String d, int vitality, int dexterity, int intelligence, int strength){
	 name = n;
	 type = t;
   this.vitality = vitality;
   this.strength = strength;
   this.dexterity = dexterity;
   this.intelligence = intelligence;
	 description = d;
 }
}
