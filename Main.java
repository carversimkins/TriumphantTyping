import javax.swing.JFrame;
public class Main {
	public static JFrame window;
	AdventureManager manager;
	/*
	This is the main method, it calls the Main constructor which sets up the JFrame as the main window for the application.
	*/
	public static void main(String[] args) {
		new Main();

	}
	/*
	Constructor for Main
	*/
	Main(){
		window = new JFrame("Learning Adventure"); //Generating main window, using JFrame
		window.setSize(1200, 800);
		window.setLayout(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		manager = new AdventureManager();
		manager.createSpace();

		Inventory.addItem(new Item( //Adding items into your inventory for the tutorial
				"Rag",
				"Armor",
				"If you squint it looks almost like armor!",
				20,
				20,
				20,
				20

				));
				Inventory.addItem(new Item(
						"Small Rock",
						"Weapon",
						"Might cause bruising!",
						1,
						1,
						1,
						1

						));


	}

}
