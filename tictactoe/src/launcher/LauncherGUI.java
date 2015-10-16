package launcher;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

import controler.TicTacToeControler;
import model.observable.TicTacToe;
import vue.MenuGUI;

public class LauncherGUI {
	public static void main(String[] args) {
		TicTacToe ticTacToe;	
		TicTacToeControler ticTacToeControler;
		JFrame frame;	
		Dimension dim;
	
		dim = new Dimension(700, 700);
		
		ticTacToe = new TicTacToe();	
		ticTacToeControler = new TicTacToeControler(ticTacToe);
		
		frame = new MenuGUI("Tic Tac Toe 3D", ticTacToeControler,  dim);
		ticTacToe.addObserver((Observer) frame);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 10);
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}
}
