import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class SudokuG extends JFrame implements KeyListener, Runnable  {

	int size=9;
	int len=3;
	JPanel[][] panels;
	JJButton[][] buttons;
	JButton[] htotal, vtotal;
	boolean noaction=false;
	Sudoku su;
	volatile boolean stop=false;
	Thread thread=null;
	Color bg;
	
	class JJButton extends JButton {
		int row, col;
		JJButton(int r, int c) {
			row=r;
			col=c;
		}
	}
	
	SudokuG(Sudoku su) {
		this.su=su;
		this.size=su.getBoardSize();
		len=(int)Math.sqrt(size);
		panels=new JPanel[len][len];
		buttons=new JJButton[size][size];
		htotal=new JButton[size];
		vtotal=new JButton[size];
		setSize(size*80,size*80);
		setLayout(new GridLayout(len+1, len+1, 10, 10));
		makeBoard();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		bg=new JButton().getBackground();
	}
	
	void makeBoard() {
		for (int l=0;l<len;l++) {
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(len, 1));
			for (int m=0;m<len;m++) {
				panels[l][m]=new JPanel();
				panels[l][m].setLayout(new GridLayout(len, len));
				add(panels[l][m]);
				jp.add(htotal[l*len+m]=new JButton());
			}
			add(jp);
		}
		for (int l=0;l<len;l++) {
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(1, len));
			for (int m=0;m<len;m++) {
				jp.add(vtotal[l*len+m]=new JButton());
			}
			add(jp);
		}
		
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				JJButton b=new JJButton(i, j);
				buttons[i][j]=b;
				b.addKeyListener(this);
				panels[i/len][j/len].add(b);
			}
		}
		showBoard();
	}
	
	public static void main(String[] args) throws Exception {
		Sudoku su=Sudoku.readBoard(new File(args[0]));
		new SudokuG(su);
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		JJButton b=(JJButton)e.getComponent();
		char c=e.getKeyChar();
		stop=c=='Q';
		if (c>='0' && c<='9') {
			if (noaction)
				return;
			int v=c-'0';
			if (su.set(b.row, b.col, v)==v) {
				if (v==0)
					b.setBackground(bg);
				else
					b.setBackground(Color.BLUE);
				b.setText(""+c);
			}
		}
		else if (c=='S') {
			if (noaction)
				su.fillBoard(true);
			else {
				su.fillBoard();
				noaction=true;
			}
			showBoard();
		}
		else if (c=='s') {
			su.fillBoard(b.row, b.col, true);
			showBoard();
		}
		else if (c=='p') {
			su.arrangeNext();
			showBoard();
		}
		else if (c=='R') {
			stop=false;
			noaction=false;
		}
		else if (c=='T') {
			if (thread==null) {
				thread=new Thread(this);
				thread.start();
			}
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	synchronized void showBoard() {
//Sudoku.printBoard();		
		int[] vsum=new int[size];
		for (int i=0;i<size;i++) {
			int sum=0;
			for (int j=0;j<size;j++) {
				int g=su.get(i,j);
				sum+=g;
				vsum[j]+=g;
				JJButton b=buttons[i][j];
				if (su.isUserSet(i,j))
					b.setBackground(Color.BLUE);
				else
					b.setBackground(bg);
				b.setText(""+g);
			}
			htotal[i].setText(""+sum);
		}
		for (int i=0;i<size;i++) {
			vtotal[i].setText(""+vsum[i]);
		}
	}
	
	public void run() {
		while (!stop) {
			su.arrangeNext();
			try{Thread.sleep(30);}catch (Exception ex){}
			showBoard();
		}
		thread=null;
	}

}
