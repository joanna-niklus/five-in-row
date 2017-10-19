import javax.swing.SwingUtilities;

import domain.Gameboard;
import ui.UserInterface;

public class Main {

    public static void main(String[] args) {
	System.out.println("Hello, world.\nThis is a game of five in a row.");

	UserInterface ui = new UserInterface(new Gameboard());
	SwingUtilities.invokeLater(ui);

	// Gameboard gameboard = new Gameboard(7);
	// gameboard.makeMove("O", 2);
	// gameboard.makeMove("O", 3);
	// gameboard.makeMove("X", 4);
	// gameboard.makeMove("O", 5);
	// gameboard.makeMove("O", 1);
	// System.out.println(gameboard.toString());


    }

}
