package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_TextUndoRedo {

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

	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel("");
	static JTextField tf = new JTextField();

	static Stack<String> edit = new Stack<String>();

	public static void main(String[] args) {

		frame.add(panel);
		panel.add(label);

		frame.setVisible(true);
		frame.pack();

		label.add(tf);

		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				int key = e.getKeyCode();
				String conv0 = Integer.toString(key);

				int lastkey = e.getKeyCode();
				String conv1 = Integer.toString(lastkey);

				if (key == KeyEvent.VK_DELETE) {

					edit.push(conv0);

				}

				else if (key == KeyEvent.VK_ENTER) {

					edit.pop();
					tf.setText(tf.getText() + conv1);

				}

				else {

					tf.setText(tf.getText() + conv0);

				}

				System.out.println(conv0);
			}
		});

	}

	/*
	 * public void keyPressed(KeyEvent e) {
	 * 
	 * int key = e.getKeyCode(); String conv0 = Integer.toString(key);
	 * 
	 * int lastkey = e.getKeyCode(); String conv1 = Integer.toString(lastkey);
	 * 
	 * if (key == KeyEvent.VK_DELETE) {
	 * 
	 * edit.push(conv0);
	 * 
	 * }
	 * 
	 * else if (key == KeyEvent.VK_ENTER) {
	 * 
	 * edit.pop(); label.setText(label.getText() + conv1);
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * label.setText(label.getText() + conv0);
	 * 
	 * }
	 * 
	 * System.out.println(conv0);
	 * 
	 * }
	 */

}
