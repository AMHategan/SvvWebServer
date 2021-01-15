package vss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordsLoader {
	private BufferedReader reader = null;

	public WordsLoader() {
		try {
			reader = new BufferedReader(new FileReader("password.lst"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getNextWord() {
		String word = null;
		try {
			word = reader.readLine();

			while (word != null && word.startsWith("#")) {
				word = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return word;
	}
}
