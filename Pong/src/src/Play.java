package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Play {
	
	private int score;
	private int lives;

	public Play() {
		lives = 3;
	}
	public void init () throws InterruptedException, IOException {
		Window win = new Window();
		win.open(this);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public int getHighscore() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Highscores.txt"));
		String line = null;
		int highscore = 0;
		while ((line = reader.readLine()) != null) {
		    highscore = Integer.parseInt(line.substring(11));
		}
		reader.close();
		return highscore;
	}
	public void setHighscore(int highscore) throws FileNotFoundException, UnsupportedEncodingException { 
			PrintWriter writer = new PrintWriter("Highscores.txt", "UTF-8");
			writer.println("High Score " + highscore);
			writer.close();
	}
}
