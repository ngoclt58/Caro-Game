package com.t3h.CaroGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Chess {
	private int locationX, locationY;
	private static final String CHESS_X = "x";
	private static final String CHESS_O = "o";
	private Color color;
	private int size;
	private boolean typeChess; // X: true - O: false
	private Font font = new Font("Tahoma", Font.BOLD, 30);

	public Chess(int locationX, int locationY, Color color, int size,
			boolean typeChess) {
		super();
		this.locationX = locationX;
		this.locationY = locationY;
		this.color = color;
		this.size = size;
		this.typeChess = typeChess;
	}

	public void draw(Graphics2D g2d) {
		if (typeChess) {
			g2d.setColor(color);
			g2d.setFont(font);
			g2d.drawString(CHESS_X, this.locationX, this.locationY);
		}
		if (!typeChess) {
			g2d.setColor(color);
			g2d.setFont(font);
			g2d.drawString(CHESS_O, this.locationX, this.locationY);
		}
	}

}
