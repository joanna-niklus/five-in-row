package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Gameboard;
import listeners.MouseListener;

public class DrawBoard extends JPanel {
    private boolean enabled;
    private Container container;
    private Gameboard board;
    private List<List<JLabel>> labels;
    private String mover;

    public DrawBoard(Container container, Gameboard board) {
	this.container = container;
	this.board = board;
	this.enabled = true;
	createBoard();
	this.mover = "O";
    }

    public Gameboard getBoard() {
	return this.board;
    }

    private void createBoard() {

	JPanel panel_0 = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_4 = new JPanel();
	JPanel panel_5 = new JPanel();
	JPanel panel_6 = new JPanel();

	panel_0.setLayout(new GridLayout(7, 1));
	panel_1.setLayout(new GridLayout(7, 1));
	panel_2.setLayout(new GridLayout(7, 1));
	panel_3.setLayout(new GridLayout(7, 1));
	panel_4.setLayout(new GridLayout(7, 1));
	panel_5.setLayout(new GridLayout(7, 1));
	panel_6.setLayout(new GridLayout(7, 1));

	panel_0.setName("0");
	panel_1.setName("1");
	panel_2.setName("2");
	panel_3.setName("3");
	panel_4.setName("4");
	panel_5.setName("5");
	panel_6.setName("6");

	labels = new ArrayList<List<JLabel>>(7);

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(0).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(0).add(label_0);
	    panel_0.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(1).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(1).add(label_0);
	    panel_1.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(2).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(2).add(label_0);
	    panel_2.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(3).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(3).add(label_0);
	    panel_3.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(4).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(4).add(label_0);
	    panel_4.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(5).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(5).add(label_0);
	    panel_5.add(label_0);
	}

	labels.add(new ArrayList<>(7));
	for (int i = 6; i >= 0; i--) {
	    JLabel label_0 = new JLabel(board.getBoard().get(6).get(i).getType(), SwingConstants.CENTER);
	    label_0.setBorder(BorderFactory.createLineBorder(Color.black));
	    labels.get(6).add(label_0);
	    panel_6.add(label_0);
	}

	panel_0.addMouseListener(new MouseListener(this, panel_0));
	panel_1.addMouseListener(new MouseListener(this, panel_1));
	panel_2.addMouseListener(new MouseListener(this, panel_2));
	panel_3.addMouseListener(new MouseListener(this, panel_3));
	panel_4.addMouseListener(new MouseListener(this, panel_4));
	panel_5.addMouseListener(new MouseListener(this, panel_5));
	panel_6.addMouseListener(new MouseListener(this, panel_6));

	container.add(panel_0);
	container.add(panel_1);
	container.add(panel_2);
	container.add(panel_3);
	container.add(panel_4);
	container.add(panel_5);
	container.add(panel_6);

    }

    public void update(int column) {
	if (this.enabled) {
	    for (int i = 0; i < 7; i++) {
		this.labels.get(column).get(i).setText(this.board.getBoard().get(column).get(6 - i).getType());
	    }
	}
    }

    public void update() {
	if (this.enabled) {
	    for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 7; j++) {
		    this.labels.get(i).get(j).setText(this.board.getBoard().get(i).get(6 - j).getType());
		}
	    }
	}
    }

    public void disableBoard() {
	this.enabled = false;
	for (int i = 0; i < 7; i++) {
	    for (int j = 0; j < 7; j++) {
		this.labels.get(i).get(j).setEnabled(false);
	    }
	}
    }

    @Override
    public boolean isEnabled() {
	return this.enabled;
    }

    public String getMover() {
	if (this.mover.equals("O")) {
	    this.mover = "X";
	    return "X";
	} else if (this.mover.equals("X")) {
	    this.mover = "O";
	    return "O";
	}
	return "_";
    }

    public String mover() {
	return this.mover;
    }
}
