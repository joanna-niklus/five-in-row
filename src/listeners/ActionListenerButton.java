package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import domain.Gameboard;
import ui.DrawBoard;

public class ActionListenerButton implements ActionListener {
    private JButton button;
    private Gameboard board;
    private DrawBoard drawer;

    public ActionListenerButton(JButton button, Gameboard board, DrawBoard draw) {
	this.button = button;
	this.board = board;
	this.drawer = draw;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	this.board.restart();
	this.drawer.update();

    }

}
