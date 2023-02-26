package _03_Hangman;

import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.Utilities;

public class Hangman {

	public static void main(String[] args) {

		// setup game
		Stack<String> words = new Stack<String>();
		String response = JOptionPane.showInputDialog("Input a number in the range of 1 - 266: ");
		int responseint = Integer.parseInt(response);
		System.out.println(responseint);
		System.out.println("");
		Utilities ut = new Utilities();
		
		// get words
		for (int i = responseint; i > 0; i--) {
			Random rand = new Random();
			int randint = rand.nextInt(266 - 1);
			System.out.println(randint);
		}

	}

}
