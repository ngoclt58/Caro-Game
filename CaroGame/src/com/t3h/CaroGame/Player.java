package com.t3h.CaroGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Player {
	public ArrayList<Chess> arrayList = new ArrayList<Chess>();
	public void playChess(int locationX, int locationY, boolean type) {
		if(type == true) {
			Chess chess = new Chess(locationX, locationY, Color.RED, 20, true);
			arrayList.add(chess);
		}
		if(type == false) {
			Chess chess = new Chess(locationX, locationY, Color.GREEN, 20, false);
			arrayList.add(chess);
		}
	}
	
	public void drawAllChess(Graphics2D g2d) {
		for (int i = 0; i <arrayList.size(); i++) {
			arrayList.get(i).draw(g2d);
		}
	}
}
