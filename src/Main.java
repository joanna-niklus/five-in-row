import domain.Gameboard;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello, world.\nThis is a game of five in a row.");

		Gameboard gameboard = new Gameboard(7);
		gameboard.makeMove("X", 2);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		gameboard.makeMove("X", 3);
		System.out.println(gameboard.toString());

	}

}
