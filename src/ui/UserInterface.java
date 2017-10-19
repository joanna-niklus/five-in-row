package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import domain.Gameboard;


public class UserInterface extends JFrame implements Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Gameboard board;

    public UserInterface(Gameboard board) {
	this.board = board;
    }


    @Override
    public void run() {
	JFrame frame = new JFrame("5 IN A ROW");
	frame.setPreferredSize(new Dimension(700, 700));
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	createComponents(frame.getContentPane());

	frame.pack();
	frame.setVisible(true);

    }

    private void createComponents(Container container) {
	container.setLayout(new GridLayout(1, 7));
	DrawBoard draw = new DrawBoard(container, board);

    }

}
