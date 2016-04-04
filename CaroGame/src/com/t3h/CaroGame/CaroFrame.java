package com.t3h.CaroGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CaroFrame extends JLabel {
	/** */
	private static final long serialVersionUID = 1L;
	private Player player1;
	private Player player2;
	private int xClicked, yClicked;
	private boolean flag = true;
	private static final int SIZE = 20;
	private int numRows, numCols;

	private char[][] square = new char[25][25];
	private boolean[][] frame = new boolean[25][25];

	private boolean charSquare = false;
	private boolean condition = false;

	private int xPlayer, yPlayer;
	private int xComputer, yComputer;

	public CaroFrame() {
		initCaroFrame();
		mouseAdapter();
		createThread();
	}

	private void createThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (flag == false) {
						int count = 0;
						boolean sequenceCheck = true;
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (condition == false) {
							// check doc
							for (int i = 0; i < numRows; i++) {
								for (int j = 0; j < numCols; j++) {
									if (square[i][j] == 120
											&& square[i + 1][j] == 120
											&& square[i + 2][j] == 120) {
										if (frame[i - 1][j]
												&& square[i - 2][j] == 120) {
											xComputer = j;
											yComputer = i - 1;
											count++;
											sequenceCheck = false;
											break;
										} else {
											if (frame[i + 3][j]
													&& square[i + 4][j] == 120) {
												xComputer = j;
												yComputer = i + 3;
												count++;
												sequenceCheck = false;
												break;
											} else {
												if (frame[i - 1][j]) {
													xComputer = j;
													yComputer = i - 1;
													count++;
													sequenceCheck = false;
													break;
												} else {
													if (frame[i + 3][j]) {
														xComputer = j;
														yComputer = i + 3;
														count++;
														sequenceCheck = false;
														break;
													}
												}
											}
										}
									}
								}
							}

							// check ngang
							if (sequenceCheck) {
								for (int i = 0; i < numRows; i++) {
									for (int j = 0; j < numCols; j++) {
										if (square[i][j] == 120
												&& square[i][j + 1] == 120
												&& square[i][j + 2] == 120) {
											if (frame[i][j - 1]
													&& square[i][j - 2] == 120) {
												xComputer = j - 1;
												yComputer = i;
												count++;
												sequenceCheck = false;
												break;
											} else {
												if (frame[i][j + 3]
														&& square[i][j + 4] == 120) {
													xComputer = j + 3;
													yComputer = i;
													count++;
													sequenceCheck = false;
													break;
												} else {
													if (frame[i][j - 1]) {
														xComputer = j - 1;
														yComputer = i;
														count++;
														sequenceCheck = false;
														break;
													} else {
														if (frame[i][j + 3]) {
															xComputer = j + 3;
															yComputer = i;
															count++;
															sequenceCheck = false;
															break;
														}
													}
												}
											}
										}
									}
								}
							}

							// check cheo tren
							if (sequenceCheck) {
								for (int i = 0; i < numRows; i++) {
									for (int j = 0; j < numCols; j++) {
										if (square[i][j] == 120
												&& square[i + 1][j + 1] == 120
												&& square[i + 2][j + 2] == 120) {
											if (frame[i - 1][j - 1]
													&& square[i - 2][j - 2] == 120) {
												xComputer = j - 1;
												yComputer = i - 1;
												count++;
												sequenceCheck = false;
												break;
											} else {
												if (frame[i + 3][j + 3]
														&& square[i + 4][j + 4] == 120) {
													xComputer = j + 3;
													yComputer = i + 3;
													count++;
													sequenceCheck = false;
													break;
												} else {
													if (frame[i - 1][j - 1]) {
														xComputer = j - 1;
														yComputer = i - 1;
														count++;
														sequenceCheck = false;
														break;
													} else {
														if (frame[i + 3][j + 3]) {
															xComputer = j + 3;
															yComputer = i + 3;
															count++;
															sequenceCheck = false;
															break;
														}
													}
												}
											}
										}
									}
								}
							}
							// check cheo duoi
							if (sequenceCheck) {
								for (int i = 0; i < numRows; i++) {
									for (int j = 0; j < numCols; j++) {
										if (square[i][j] == 120
												&& square[i - 1][j + 1] == 120
												&& square[i - 2][j + 2] == 120) {
											if (frame[i + 1][j - 1]
													&& square[i + 2][j - 2] == 120) {
												xComputer = j - 1;
												yComputer = i + 1;
												count++;
												sequenceCheck = false;
												break;
											} else {
												if (frame[i - 3][j + 3]
														&& square[i - 4][j + 4] == 120) {
													xComputer = j + 3;
													yComputer = i - 3;
													count++;
													sequenceCheck = false;
													break;
												} else {
													if (frame[i + 1][j - 1]) {
														xComputer = j - 1;
														yComputer = i + 1;
														count++;
														sequenceCheck = false;
														break;
													} else {
														if (frame[i - 3][j + 3]) {
															xComputer = j + 3;
															yComputer = i - 3;
															count++;
															sequenceCheck = false;
															break;
														}
													}
												}
											}
										}
									}
								}
							}
							// check hinh chu thap
							if (sequenceCheck) {
								for (int i = 0; i < numRows; i++) {
									for (int j = 0; j < numCols; j++) {
										if (square[i][j] == 120
												&& square[i - 1][j + 1] == 120
												&& square[i + 1][j + 1] == 120
												&& square[i][j + 2] == 120
												&& frame[i][j + 1]) {
											xComputer = j + 1;
											yComputer = i;
											count++;
											sequenceCheck = false;
											break;
										}
									}
								}
							}
							if (count == 0) {
								condition = true;
							}
						}
						if (condition == true) {
							int xRand = randNum(-1, 1);
							int yRand = randNum(-1, 1);
							xComputer = (xPlayer + xRand);
							yComputer = (yPlayer + yRand);
							while (!frame[yComputer][xComputer]) {
								xRand = randNum(-1, 1);
								yRand = randNum(-1, 1);
								xComputer = (xPlayer + xRand);
								yComputer = (yPlayer + yRand);
							}
							condition = false;
							System.out.println(xRand + "-" + yRand);
						}
						System.out.println(xComputer + "-" + yComputer);
						System.out
								.println("--------------------------------------------------");
						player1.playChess(xComputer * SIZE, (yComputer + 1)
								* SIZE, flag);
						flag = true;
						squareGetValue();
					}
					repaint();
				}
			}
		});
		thread.start();
	}

	private void mouseAdapter() {
		MouseAdapter mouseAdapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				xClicked = e.getX();
				yClicked = e.getY();
				xPlayer = xClicked / SIZE;
				yPlayer = yClicked / SIZE;
				int xDraw = (xPlayer * SIZE);
				int yDraw = (yPlayer * SIZE) + SIZE;
				System.out.println(xPlayer + "-" + yPlayer + "-");
				if (flag == true) {
					player1.playChess(xDraw, yDraw, flag);
					flag = false;
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
							break;
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
							break;
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
							break;
						}
						if ((square[i][j] == 111 && square[i][j + 1] == 111
								&& square[i][j + 2] == 111
								&& square[i][j + 3] == 111 && square[i][j + 4] == 111)) {
							JOptionPane.showMessageDialog(null,
									"Bên O chiến thắng!");
							break;
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

		};
		addMouseListener(mouseAdapter);
	}

	private void squareGetValue() {
		if (flag == false) {
			square[yPlayer][xPlayer] = 120;
			frame[yPlayer][xPlayer] = false;
		}

		if (flag == true) {
			square[yComputer][xComputer] = 111;
			frame[yComputer][xComputer] = false;
		}

		// for (int i = 0; i < numRows; i++) {
		// for (int j = 0; j < numCols; j++) {
		// System.out.print(square[i][j]);
		// }
		// System.out.println();
		// }
		// System.out.println();
		//
		// for (int i = 0; i < numRows; i++) {
		// for (int j = 0; j < numCols; j++) {
		// System.out.print(frame[i][j]);
		// }
		// System.out.println();
		// }
		// System.out.println();
	}

	private void initCaroFrame() {
		numCols = GUI.HEIGHT / SIZE;
		numRows = GUI.WIDTH / SIZE;
		setLayout(null);
		player1 = new Player();
		player2 = new Player();
	}

	private void drawCaroFrame(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		for (int y = 0; y < GUI.HEIGHT; y += 20) {
			g2d.drawLine(0, y, GUI.HEIGHT, y);
		}
		for (int x = 0; x < GUI.WIDTH; x += 20) {
			g2d.drawLine(x, 0, x, GUI.WIDTH);
		}

		// int startY = 0;
		// for (int i = 0; i < numRows; i++) {
		// // int startX = 0;
		// for (int j = 0; j < numCols; j++) {
		// // g2d.drawRect(startX, startY, SIZE, SIZE);
		// // startX += SIZE;
		// if (charSquare == false) {
		// square[i][j] = 12;
		// frame[i][j] = true;
		// charSquare = true;
		// }
		// }
		// // startY += SIZE;
		// }
		if (charSquare == false) {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					frame[i][j] = true;
				}
			}
			charSquare = true;
		}
	}

	private int randNum(int min, int max) {
		Random r = new Random();
		int range = max - min + 1;
		int randNum = min + r.nextInt(range);
		return randNum;
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
