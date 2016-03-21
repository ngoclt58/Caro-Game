package com.t3h.CaroGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuPanel extends JLabel{
	private JLabel labelBackground, labelTitle;
	private JButton btPlayGame, btIntroduction, btOption;
	private Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC, 20);
	
	public MenuPanel() {
		initMenuPanel();
		initCopms();
		addComps();
	}

	private void initCopms() {
		labelTitle = new JLabel("Caro Version Ngọc Lê");
		labelTitle.setFont(font);
		labelTitle.setBounds(150, 50, 400, 30);
		labelTitle.setForeground(Color.RED);
		
		btPlayGame = new JButton("Play Game");
		btPlayGame.setFont(font);
		btPlayGame.setBounds(150, 120, 200, 30);
		
		btIntroduction = new JButton("Introduction");
		btIntroduction.setFont(font);
		btIntroduction.setBounds(150, 190, 200, 30);
		
		btOption = new JButton("Option");
		btOption.setFont(font);
		btOption.setBounds(150, 260, 200, 30);
		
		labelBackground = new JLabel();
		ImageIcon imageBackground = new ImageIcon(getClass().getResource("/image/background.png"));
		labelBackground.setIcon(imageBackground);
		labelBackground.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());
	}

	private void addComps() {
		add(labelTitle);
		add(btPlayGame);
		add(btIntroduction);
		add(btOption);
		add(labelBackground);
	}

	private void initMenuPanel() {
		setLayout(null);
	}

	public JButton getBtPlayGame() {
		return btPlayGame;
	}

	public JButton getBtIntroduction() {
		return btIntroduction;
	}

	public JButton getBtOption() {
		return btOption;
	}
	
	
}
