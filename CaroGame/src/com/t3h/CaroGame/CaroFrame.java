package com.t3h.CaroGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CaroFrame extends JLabel {
	private Player player1;
	private Player player2;
	private int xClicked, yClicked;
	private boolean flag = true;
	private static final int SIZE = 20;
	private int numRows, numCols;
	private char[][] square = new char[25][25];
	private boolean charSquare = false;

	public CaroFrame() {
		initCaroFrame();
		mouseAdapter();
	}

	private int x, y;

	private void mouseAdapter() {
		MouseAdapter mouseAdapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				xClicked = e.getX();
				yClicked = e.getY();
				x = xClicked / SIZE;
				y = yClicked / SIZE;
				int xDraw = (x * SIZE);
				int yDraw = (y * SIZE) + SIZE;
				System.out.println(x + "-" + y + "-");
				if (flag == true) {
					player1.playChess(xDraw, yDraw, flag);
					flag = false;
				} else {
					player2.playChess(xDraw, yDraw, flag);
					flag = true;
				}
				squareGetValue();
				repaint();
				checkWin();
			}

			private void checkWin() {
				checkVertical();
				checkHorizontal();
				checkDiagonal();
			}

			private void checkDiagonal() {
				for (int i = 0; i < numRows; i++) {
					for (int j = 0; j < numCols; j++) {
						if ((square[i][j] == 120 && square[i - 1][j + 1] == 120
								&& square[i - 2][j + 2] == 120
								&& square[i - 3][j + 3] == 120 && square[i - 4][j + 4] == 120)
								|| (square[i][j] == 120
										&& square[i + 1][j + 1] == 120
										&& square[i + 2][j + 2] == 120
										&& square[i + 3][j + 3] == 120 && square[i + 4][j + 4] == 120)) {
							JOptionPane.showMessageDialog(null,
									"Bên X chiến thắng!");
						}
						if ((square[i][j] == 111 && square[i - 1][j + 1] == 111
								&& square[i - 2][j + 2] == 111
								&& square[i - 3][j + 3] == 111 && square[i - 4][j + 4] == 111)
								|| (square[i][j] == 111
										&& square[i + 1][j + 1] == 111
										&& square[i + 2][j + 2] == 111
										&& square[i + 3][j + 3] == 111 && square[i + 4][j + 4] == 111)) {
							JOptionPane.showMessageDialog(null,
									"Bên O chiến thắng!");
						}
					}
				}
			}

			private void checkHorizontal() {
				for (int i = 0; i < numRows; i++) {
					for (int j = 0; j < numCols; j++) {
						if ((square[i][j] == 120 && square[i][j + 1] == 120
								&& square[i][j + 2] == 120
								&& square[i][j + 3] == 120 && square[i][j + 4] == 120)) {
							JOptionPane.showMessageDialog(null,
									"Bên X chiến thắng!");
						}
						if ((square[i][j] == 111 && square[i][j + 1] == 111
								&& square[i][j + 2] == 111
								&& square[i][j + 3] == 111 && square[i][j + 4] == 111)) {
							JOptionPane.showMessageDialog(null,
									"Bên O chiến thắng!");
						}
					}
				}
			}

			private void checkVertical() {
				for (int i = 0; i < numRows; i++) {
					for (int j = 0; j < numCols; j++) {
						if ((square[i][j] == 120 && square[i + 1][j] == 120
								&& square[i + 2][j] == 120
								&& square[i + 3][j] == 120 && square[i + 4][j] == 120)) {
							JOptionPane.showMessageDialog(null,
									"Bên X chiến thắng!");
						}
						if ((square[i][j] == 111 && square[i + 1][j] == 111
								&& square[i + 2][j] == 111
								&& square[i + 3][j] == 111 && square[i + 4][j] == 111)) {
							JOptionPane.showMessageDialog(null,
									"Bên O chiến thắng!");
						}
					}
				}
			}

			private void squareGetValue() {
				if (flag == false) {
					square[y][x] = 120;
				}
				if (flag == true) {
					square[y][x] = 111;
				}
				for (int i = 0; i < numRows; i++) {
					for (int j = 0; j < numCols; j++) {
						System.out.print(square[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			}

		};
		addMouseListener(mouseAdapter);
	}

	private void initCaroFrame() {
		numCols = GUI.HEIGHT / SIZE;
		numRows = GUI.WIDTH / SIZE;
		setBackground(Color.PINK);
		setLayout(null);
		player1 = new Player();
		player2 = new Player();
	}

	private void drawCaroFrame(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		int startY = 0;
		for (int i = 0; i < numRows; i++) {
			int startX = 0;
			for (int j = 0; j < numCols; j++) {
				g2d.drawRect(startX, startY, SIZE, SIZE);
				startX += SIZE;
				if (charSquare == false) {
					square[i][j] = 12;
					charSquare = true;
				}
			}
			startY += SIZE;
		}
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		drawCaroFrame(g2d);
		player1.drawAllChess(g2d);
		player2.drawAllChess(g2d);
	}
}
