package domain;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    private List<List<Marker>> board;
    private int dimensions;

    public Gameboard(int dimensions) {
	this.dimensions = dimensions;
	this.board = new ArrayList<>(dimensions);
	for (int i = 0; i < dimensions; i++) {
	    this.board.add(new ArrayList<Marker>());
	    for (int j = 0; j < dimensions; j++) {
		this.board.get(i).add(new Marker(i, j, ""));
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
	if (!check.equals("")) {
	    return check;
	}
	check = this.verticalWin();
	if (!check.equals("")) {
	    return check;
	}
	// TODO diagonal win checks!

	return "";
    }

    private String verticalWin() {
	String helperStr = "";
	int helperInt = 0;
	for (List<Marker> column : board) {
	    for (Marker marker : column) {
		if (helperInt == 5) {
		    return helperStr;
		}
		if (marker.getType().equals(helperStr) && !helperStr.equals("")) {
		    helperInt++;
		} else {
		    helperStr = marker.getType();
		    helperInt = 1;
		}
	    }
	}
	return "";
    }

    private String horisontalWin() {
	String helperStr = "_";
	int helperInt = 0;
	for (int i = 0; i < board.size(); i++) {
	    for (int j = 0; j < board.get(i).size(); j++) {
		if (helperInt == 5) {
		    return helperStr;
		}
		if (board.get(j).get(i).getType().equals(helperStr) && !helperStr.equals("_")) {
		    helperInt++;
		} else {
		    helperStr = board.get(j).get(i).getType();
		    helperInt = 1;
		}
	    }
	}
	return "_";
    }

    public int getDimensions() {
	return this.dimensions;
    }


    @Override
    public String toString() {
	StringBuilder answer = new StringBuilder();
	for (int i = board.size() - 1; i >= 0; i--) { // prints out the arrays bottom -> up
	    for (int j = 0; j < board.get(i).size(); j++) {
		answer.append(board.get(j).get(i));
	    }
	    answer.append("\n");
	}
	return answer.toString();
    }

}
