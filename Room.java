import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Room extends Thread{
	//initialization of all variables
	static int floorHeight =700;
	static int gold = 5;
	int level = 1;
	boolean running = false;
	static boolean clear;
	ImageIcon background;
	public static Music musicPlayer = new Music();
	Timer t;
	boolean spawn = false;
	int first =0, first1=0, beginning = 10, end = 1135;
	public static JPanel floor, dataPanel;
	public JLabel mainPanel = new JLabel();
	public static JLabel healthInfo;
	private Room leftRoom, rightRoom;
	static Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	static Font TextFont = new Font("Comic Sans MS", Font.PLAIN, 25);
	String factoryMusic = ".//res//Laserpack.wav";
	String DRUM = ".//res//CarverGameMusic.wav";

	//Initialization of all ArrayLists
	 ArrayList<Platform> blocks = new ArrayList<Platform>();
	 ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	 ArrayList<NPC> NPCs = new ArrayList<NPC>();
	 ArrayList<Treasure> chests = new ArrayList<Treasure>();
	 ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	 ArrayList<Projectile> enemyProjectiles = new ArrayList<Projectile>();
	 ArrayList<ForceField> fields = new ArrayList<ForceField>();
	 ArrayList<Trap> traps = new ArrayList<Trap>();

	Room(String bg){
		leftRoom = null;
		rightRoom = null;
		background = new ImageIcon(getClass().getClassLoader().getResource(bg + ".png"));
	}

	/*
	Runs the room
	@Param: none
	@Return: none
	*/
	public void run() {
		running = true;
		make();
	}

	/*
	Spawns the room
	@Param: none
	@Return: none
	*/
	public void make(){
		//spawns the room
		if(spawn == true) {
			AdventureManager.spawnRoom = this;
		}

		//sets this room to the current room and sets the player inside of the room
		AdventureManager.currentRoom = this;
		AdventureManager.toon.x = AdventureManager.start;
		AdventureManager.mainPanel.setIcon(background);
		//initialization of enemies, chests, blocks, and npcs
		for(int i =0; i<enemies.size(); i++) {
			enemies.get(i).alive = true;
			enemies.get(i).setVisible(true);
			AdventureManager.mainPanel.add(enemies.get(i));
		}
		for(int i =0; i<chests.size(); i++) {
			AdventureManager.mainPanel.add(chests.get(i));
		}
		for(int i =0; i<blocks.size(); i++) {
			AdventureManager.mainPanel.add(blocks.get(i));
		}
		for(int i =0; i<NPCs.size(); i++) {
			AdventureManager.mainPanel.add(NPCs.get(i));
			NPCs.get(i).dialoguePanel.setVisible(false);
		}
		AdventureManager.mainPanel.repaint();

		//setting of timer
		t = new Timer(5, new ActionListener() {

			@Override
			/*
			This method is used for a room-wide update
			@Param: ActionEvent (not used)
			@Return: none
			*/
			public void actionPerformed(ActionEvent arg0) {
				//Update every object in the room by looping through various ArrayLists

				AdventureManager.toon.Update();
				if(!fields.isEmpty())fields.get(0).update();
				AdventureManager.n.Update();
				for(int i = 0; i<projectiles.size(); i++) {
					projectiles.get(i).update();
				}
				for(int i = 0; i<traps.size(); i++) {
					traps.get(i).update();
				}
				for(int i = 0; i<enemyProjectiles.size(); i++) {
					enemyProjectiles.get(i).update();
				}
				for(int i = 0; i<blocks.size(); i++) {
					blocks.get(i).update();
				}

				for(int i = 0; i<chests.size(); i++) {
					chests.get(i).update();
				}
				for(int i =0; i<NPCs.size(); i++) {
					NPCs.get(i).update();
				}
				for(int i = 0; i<enemies.size(); i++) {
					enemies.get(i).Update();
				}

				//Check to see if adventurer is moving to a different room
				if(AdventureManager.toon.x < 0) {
					if(leftRoom == null) {
						AdventureManager.toon.x = 0; //Main.window.repaint();
					}
					else {
						deleteMain();
						AdventureManager.start = end;
						if(leftRoom.running == true) {leftRoom.make();}
						else {leftRoom.start();}
					}
				}
				if(AdventureManager.toon.x +50 > 1194) {
					if(rightRoom == null) {
						AdventureManager.toon.x = 1145; //Main.window.repaint();
					}
					else {

						deleteMain();
						AdventureManager.start = beginning;

						if(rightRoom.running == true) {rightRoom.make();}
						else {rightRoom.start();}
					}
				}
			}

		}); t.start();

		//Main.window.repaint();
	}

	/*
	Removes all items of the room from the screen
	@Param: none
	@Return: none
	*/
	public void deleteMain() {

		for(int i =0; i<blocks.size(); i++) {
			AdventureManager.mainPanel.remove(blocks.get(i));
		}
		for(int i =0; i<projectiles.size(); i++) {
			AdventureManager.mainPanel.remove(projectiles.get(i));
		}
		for(int i =0; i<enemyProjectiles.size(); i++) {
			AdventureManager.mainPanel.remove(enemyProjectiles.get(i));
		}
		for(int i =0; i<fields.size(); i++) {
			AdventureManager.mainPanel.remove(fields.get(i));
			fields.remove(fields.get(i));
		}
		for(int i =0; i<chests.size(); i++) {
			AdventureManager.mainPanel.remove(chests.get(i));
		}
		for(int i =0; i<enemies.size(); i++) {
			AdventureManager.mainPanel.remove(enemies.get(i));
		}
		for(int i =0; i<NPCs.size(); i++) {
			AdventureManager.mainPanel.remove(NPCs.get(i));
		}
		AdventureManager.currentRoom.t.stop();
		//System.out.println("Main Deleted");
		Main.window.repaint();


	}

	/*
	Methods for adding different elements to the rooms
	*/
	public void addPlatform(Platform p) {
		blocks.add(p);
		p.setVisible(true);
		Main.window.repaint();
	}
	public void addRightRoom(Room r) {
		rightRoom = r;
	}
	public void addLeftRoom(Room r) {
		leftRoom = r;
	}
	public void addEnemies(Enemy e) {
		enemies.add(e);
		e.setVisible(true);
		Main.window.repaint();
	}
	public void addNPC(NPC q) {
		NPCs.add(q);
		q.setVisible(true);
		Main.window.repaint();
	}
	public void addChest(Treasure t) {
		chests.add(t);
		t.setVisible(true);
		Main.window.repaint();
	}
	public void addTrap(Trap t) {
		traps.add(t);
		Main.window.repaint();
	}
	public void setRespawn() {
		spawn = true;
	}

}
