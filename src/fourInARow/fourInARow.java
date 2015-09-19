package fourInARow;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class fourInARow extends Applet implements Symbols, MouseListener{
	int[][] board = new int[7][7];
	int turn = 1;
	JOptionPane message = new JOptionPane();
	
	public void init() {
		setSize(710, 710);
		setBackground(Color.LIGHT_GRAY);
		addMouseListener(this);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		for (int i = 0; i <= 700; i+=100) {
			if (x > i && x < i + 100) {
				if (turn == RED) {
					draw(i, y(i, 600), Color.red);
					turn++;
				}
				else if (turn == YELLOW) {
					draw(i, y(i, 600), Color.yellow);
					turn--;
				}
			}
		}
		check();
	}
	
	public void check(){
		//rows
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != EMPTY && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
					switch (board[i][j]) {
					case RED:
						message.showMessageDialog(null, "Red wins!!!");
						System.exit(0);
						break;
					case YELLOW:
						message.showMessageDialog(null, "Yellow wins!!!");
						System.exit(0);
						break;
					}
				}
			}
		}
		
		//columns
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != EMPTY && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
					switch (board[i][j]) {
					case RED:
						message.showMessageDialog(null, "Red wins!!!");
						System.exit(0);
						break;
					case YELLOW:
						message.showMessageDialog(null, "Yellow wins!!!");
						System.exit(0);
						break;
					}
				}
			}
		}
		
		//diagonals (down right)
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != EMPTY && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3]) {
					switch (board[i][j]) {
					case RED:
						message.showMessageDialog(null, "Red wins!!!");
						System.exit(0);
						break;
					case YELLOW:
						message.showMessageDialog(null, "Yellow wins!!!");
						System.exit(0);
						break;
					}
				}
			}
		}
		
		//diagonals (down left)
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j < 7; j++) {
				if (board[i][j] != EMPTY && board[i][j] == board[i+1][j-1] && board[i][j] == board[i+2][j-2] && board[i][j] == board[i+3][j-3]) {
					switch (board[i][j]) {
					case RED:
						message.showMessageDialog(null, "Red wins!!!");
						System.exit(0);
						break;
					case YELLOW:
						message.showMessageDialog(null, "Yellow wins!!!");
						System.exit(0);
						break;
					}
				}
			}
		}
		
		/*
		 * for debugging...
		 * */
//		System.out.println("------------------");
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print("("+ i + ", " + j + "= " + board[i][j] + ")");
//			}
//			System.out.println();
//		}
	}
	
	public int y(int x, int y){
		if (board[x/100][y/100] == EMPTY) {
			return y;
		}
		return y(x, y-=100);
	}
	
	public void draw(int x, int y, Color c){
		Graphics g = this.getGraphics();
		g.setColor(c);
		g.fillOval(x, y, 100, 100);
		if (c == Color.red) {
			board[x/100][y/100] = RED;
		}
		else {
			board[x/100][y/100] = YELLOW;
		}
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i <= 700; i+=100) {
			g.drawLine(i, 0, i, 700);
			g.drawLine(0, i, 700, i);
		}
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
