package vss;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private JButton button = null;
	private JTextArea wordArea = null;
	private LinkedList<Double> list = new LinkedList<Double>();
	
	private MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Testing Ground");
		setLayout(new BorderLayout());
		setSize(400, 300);

		button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			private WordsLoader wordsLoader = null;

			public void actionPerformed(ActionEvent e) {
				String s = null;
				
				for (int i = 0; i < 10000; i++) {
					list.add(new Double(i));
					s = s + i;
				}
				//list.removeAll(list);
				
				
				if (wordsLoader == null) {
					wordsLoader = new WordsLoader();
				}
				wordArea.append(wordsLoader.getNextWord() + "\n");
			}

		});

		wordArea = new JTextArea();
		wordArea.setEditable(false);
		add(new JScrollPane(wordArea), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}
