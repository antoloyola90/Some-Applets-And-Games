
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class rid extends JApplet implements MouseListener {

	private char[][] board;

	private boolean player1turn, winner, done;

	private char choice;

	private MyPanel canvas;

	private int count;

	private boolean[][] taken;

	public rid() {
		board = new char[4][4];
		taken = new boolean[4][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				taken[i][j] = false;
			}
		}
	}

	public void init() {
		int count = 49;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = (char) count;
				count++;
			}
		}
		done = winner = false;
		player1turn = true;
		canvas = new MyPanel();
		setContentPane(canvas);
		canvas.setBackground(Color.BLACK);
		canvas.addMouseListener(this);
	}

	class MyPanel extends JPanel {

		public void paint(Graphics g) {
			for (int i = 1; i < 9; i++) {
				//g.setColor(Color.black);
				Color m = Color.getHSBColor((float) Math.random(), 0.6F, 0.6F);
				g.setColor(m);
				g.drawLine(0, i * 50, 400, i * 50);
				g.drawLine(i * 50, 0, i * 50, 400);
				g.drawLine(0, i * 50 + 1, 400, i * 50 + 1);
				g.drawLine(i * 50 + 1, 0, i * 50 + 1, 400);

			}
			g.fillRect(0, 0, 400, 400);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					g.setColor(Color.white);
					g.drawLine(i * 100, 0, i * 100, 400);
					g.drawLine(i * 100 + 1, 0, i * 100 + 1, 400);
					g.drawLine(0, j * 100, 400, j * 100);
					g.drawLine(0, j * 100 + 1, 400, j * 100 + 1);
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.isShiftDown()) {
			count = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					taken[i][j] = false;
				}
			}
			repaint();
			return;
		}
		int x = e.getX();
		int y = e.getY();
		Graphics k = getGraphics();
		if (x >= 0 && x <= 400 && y >= 0 && y <= 400 && !done) {
			int row = y / 100;
			int col = x / 100;
			if (taken[row][col] == false) {
				count++;
				while (count < 17 && taken[row][col] == false) {
					taken[row][col] = true;
					k.setFont(new Font("serif", Font.BOLD, 40));
					k.setColor(Color.red);
					k.drawString("" + count, col * 100 + 40, row * 100 + 60);
				}
			}
		}
		k.dispose();

	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

