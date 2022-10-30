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

	static JFrame frame = new JFrame("Frame");
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();

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
		
		Stack<String> text = new Stack<String>();
		Stack<String> pop = new Stack<String>();
		
		int key = e.getKeyCode();
		String convert = Integer.toString(key);
		
		int last = e.getKeyCode() - 1;
		String lastconvert = Integer.toString(last);

		if( key == KeyEvent.VK_BACK_SPACE) {			
			
			// remove from jlabel
			text.pop();
			
			// save to stack
			pop.push(lastconvert);
			
		}

		else if(key == KeyEvent.VK_ENTER) {
			
			// pop from stack
			pop.pop();
			
			// add to jlabel
			text.push(lastconvert);
			
		}

		else {
			
			// add to jlabel
			text.push(convert);
			label.setText(text.toString());
			
		}
		
		System.out.println(text.toString());
		
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
