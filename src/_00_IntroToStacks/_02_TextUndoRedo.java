package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */

	static JFrame frame = new JFrame("Text Editor");
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();

	Stack<Character> deleted = new Stack<Character>();

	public static void main(String[] args) {

		_02_TextUndoRedo tur = new _02_TextUndoRedo();
		tur.setup();

	}

	public void setup() {

		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);

		frame.setVisible(true);
		frame.pack();

	}

	public void keyPressed(KeyEvent e) {

		char keychar = e.getKeyChar();
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_BACK_SPACE) {

			if (label.getText().length() > 0) {
				
				deleted.push(label.getText().charAt(label.getText().length() - 1));
				label.setText(label.getText().substring(0, label.getText().length() - 1));
							
			}

		}

		else if (key == KeyEvent.VK_ENTER) {

			if (deleted.size() > 0) {
				
				label.setText(label.getText() + deleted.pop());

			}
		}

		else {

			label.setText(label.getText() + keychar);

		}

		System.out.println(label.getText());

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
