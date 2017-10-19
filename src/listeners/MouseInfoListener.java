package listeners;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import ui.DrawBoard;

public class MouseInfoListener implements java.awt.event.MouseListener{
    private DrawBoard board;
    private JLabel info;
    

    public MouseInfoListener(DrawBoard board, JLabel info) {
	this.board = board;
	this.info = info;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	info.setText("MOVER: " + board.mover());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }


}
