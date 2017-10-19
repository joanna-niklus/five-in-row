package listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ui.DrawBoard;

public class MouseListener implements java.awt.event.MouseListener {
    private DrawBoard drawer;
    private JPanel panel;

    public MouseListener(DrawBoard drawer, JPanel panel) {
	this.panel = panel;
	this.drawer = drawer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	if (!drawer.isEnabled()) {
	    System.exit(0);
	}
	drawer.getBoard().makeMove(drawer.getMover(), Integer.parseInt(e.getComponent().getName()));
	drawer.update(Integer.parseInt(e.getComponent().getName()));
	if (!drawer.getBoard().hasWon().equals("")) {
	    JLabel winner = new JLabel(drawer.getBoard().hasWon() + " has won!!", SwingConstants.CENTER);
	    JOptionPane.showMessageDialog(null, winner, "InfoBox: " + "5 IN A ROW", JOptionPane.PLAIN_MESSAGE);
	    drawer.disableBoard();
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	panel.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
	panel.setBackground(null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
