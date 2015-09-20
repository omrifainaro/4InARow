package fourInARow;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;

import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.JOptionPane;

public class fourInARow extends Applet implements Symbols, MouseListener, KeyListener{
	int[][] board = new int[7][7];
	int turn = 1;
	JOptionPane message = new JOptionPane();
	
	public void init() {
		setSize(710, 710);
		setBackground(Color.LIGHT_GRAY);
		addMouseListener(this);
		addKeyListener(this);
		
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
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			if (turn == RED) {
				draw(0, y(0, 600), Color.red);
				turn++;
			}
			else{
				draw(0, y(0, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_2:
			if (turn == RED) {
				draw(100, y(100, 600), Color.red);
				turn++;
			}
			else{
				draw(100, y(100, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_3:
			if (turn == RED) {
				draw(200, y(200, 600), Color.red);
				turn++;
			}
			else{
				draw(200, y(200, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_4:
			if (turn == RED) {
				draw(300, y(300, 600), Color.red);
				turn++;
			}
			else{
				draw(300, y(300, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_5:
			if (turn == RED) {
				draw(400, y(400, 600), Color.red);
				turn++;
			}
			else{
				draw(400, y(400, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_6:
			if (turn == RED) {
				draw(500, y(500, 600), Color.red);
				turn++;
			}
			else{
				draw(500, y(500, 600), Color.yellow);
				turn--;
			}
			break;
		case KeyEvent.VK_7:
			if (turn == RED) {
				draw(600, y(600, 600), Color.red);
				turn++;
			}
			else{
				draw(600, y(600, 600), Color.yellow);
				turn--;
			}
			break;
		}
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
		
		if (isFull()) {
			message.showMessageDialog(null, "its a tie!!");
			System.exit(0);
		}
	}
	
	public boolean isFull(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == EMPTY) {
					return false;
				}
			}
		}
		return true;
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
			try {
				board[x/100][y/100] = RED;
			} catch (Exception e) {}
		}
		else {
			try {
				board[x/100][y/100] = YELLOW;
			} catch (Exception e) {}	
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
