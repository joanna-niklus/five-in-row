package domain;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {
	private List<List<Marker>> board;

	public Gameboard(int dimensions) {
		this.board = new ArrayList<>(dimensions);
		for (int i = 0; i < dimensions; i++) {
			this.board.add(new ArrayList<Marker>());
			for (int j = 0; j < dimensions; j++) {
				this.board.get(i).add(new EmptyMarker(i, j));
			}
		}
	}

	public List<List<Marker>> getBoard() {
		return board;
	}

	public boolean makeMove(String whoseTurn, int column) {
		for (int i = 0; i < board.get(column).size(); i++) {
			if (board.get(column).get(i).isEmpty()) {
				board.get(column).get(i).setType(whoseTurn);
				return true;
			}
		}
		return false;
	}

	public String hasWon() {
		String check = this.horisontalWin();
		if (!check.equals("_")) {
			return check;
		}
		check = this.verticalWin();
		if (!check.equals("_")) {
			return check;
		}

		return "_";
	}

	private String verticalWin() {

		return "_";
	}

	private String horisontalWin() {
		return "_";
	}

	@Override
	public String toString() {
		StringBuilder answer = new StringBuilder();
		for (int i = board.size() - 1; i >= 0; i--) { // prints out the arrays bottom -> up
			for (int j = board.get(i).size() - 1; j >= 0; j--) {
				answer.append(board.get(j).get(i));
			}
			answer.append("\n");
		}
		return answer.toString();
	}

}
