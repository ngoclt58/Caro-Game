package com.t3h.CaroGame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private PlayGamePanel playGamePanel;
	private MenuPanel menuPanel;
	public GUI() {
		initGUI();
		initComps();
		addComps();
		music();
		click();
	}

	private void click() {
		menuPanel.getBtPlayGame().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuPanel.setVisible(false);
				GUI.this.add(playGamePanel);
				playGamePanel.setVisible(true);
			}
		});
		
		menuPanel.getBtIntroduction().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Óc chó! Game Caro mà cũng ko biết chơi");
			}
		});
	}

	private void music() {
		Sound sound = new Sound("D:/ahihi.wav");
		sound.start();
	}

	private void addComps() {
		add(menuPanel);
		add(playGamePanel);
	}

	private void initComps() {
		menuPanel = new MenuPanel();
		playGamePanel = new PlayGamePanel();
		playGamePanel.setVisible(false);
	}

	private void initGUI() {
		setTitle("Game Caro");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setLayout(new CardLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
