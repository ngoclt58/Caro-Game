package com.t3h.CaroGame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayGamePanel extends JPanel{
	private CaroFrame caroFrame;
	public PlayGamePanel() {
		initPlayGamePanel();
		initComps();
		addComps();
	}

	private void addComps() {
		add(caroFrame);
	}

	private void initComps() {
		caroFrame = new CaroFrame();
	}

	private void initPlayGamePanel() {
		setLayout(new CardLayout());
	}
}
