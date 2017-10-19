package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import domain.Gameboard;
import listeners.ActionListenerButton;

public class UserInterface extends JFrame implements Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Gameboard board;
    private JFrame frame;

    public UserInterface(Gameboard board) {
	this.board = board;
	this.frame = new JFrame("5 IN A ROW");
    }

    @Override
    public void run() {
	frame.setPreferredSize(new Dimension(700, 700));
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	createComponents(frame.getContentPane());

	frame.pack();
	frame.setVisible(true);
	setWindowPosition(frame, 1);

    }

    private void createComponents(Container container) {
	JPanel infoArea = new JPanel();
	JPanel gameArea = new JPanel();
	JPanel optionsArea = new JPanel();

	container.setLayout(new BorderLayout());


	gameArea.setLayout(new GridLayout(1, 7));
	DrawBoard draw = new DrawBoard(gameArea, board); // TODO make this better..

	JButton restart = new JButton("Restart");
	restart.addActionListener(new ActionListenerButton(restart, board, draw));
	optionsArea.add(restart);

	container.add(infoArea, BorderLayout.NORTH);
	container.add(gameArea, BorderLayout.CENTER);
	container.add(optionsArea, BorderLayout.SOUTH);
    }

    private void setWindowPosition(JFrame window, int screen) {
	// code from Stackoverflow
	// credits to https://stackoverflow.com/users/499770/peter-szabo
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice[] allDevices = env.getScreenDevices();
	int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;

	if (screen < allDevices.length && screen > -1) {
	    topLeftX = allDevices[screen].getDefaultConfiguration().getBounds().x;
	    topLeftY = allDevices[screen].getDefaultConfiguration().getBounds().y;

	    screenX = allDevices[screen].getDefaultConfiguration().getBounds().width;
	    screenY = allDevices[screen].getDefaultConfiguration().getBounds().height;
	} else {
	    topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
	    topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;

	    screenX = allDevices[0].getDefaultConfiguration().getBounds().width;
	    screenY = allDevices[0].getDefaultConfiguration().getBounds().height;
	}

	windowPosX = ((screenX - window.getWidth()) / 2) + topLeftX;
	windowPosY = ((screenY - window.getHeight()) / 2) + topLeftY;

	window.setLocation(windowPosX, windowPosY);
    }
}
