package src;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;

public class Window {

	Graphics g;
	
	public Window () {
		//
	}
	public void open (Play game) throws InterruptedException, IOException {
		Screen sc = new Screen(game);
		JFrame win = new JFrame("Pong");
		win.setLocation(200,100);
		win.setSize(800,600);
		win.setVisible(true);
		win.getContentPane().setBackground(new Color(0,0,0));
		win.getContentPane().add(sc);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		win.addKeyListener(sc);
		
		Container contentPane = win.getContentPane();
		g = contentPane.getGraphics();

		try{Thread.sleep(400);} catch (Exception e) {}
		
		g.setColor(new Color(250, 255, 255));
		
		sc.paint(g);
		try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		
		GameOverListener gO = null;
		
		while(true) {
			for(KeyListener j: win.getKeyListeners()) {
				if(j.equals(gO))
					win.removeKeyListener(gO);
			}
			sc.updateBall();
			sc.repaint();
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
			if(game.getLives() == 0) {
				
				
				int highscore = game.getHighscore();
				if(highscore < game.getScore()) {
					highscore = game.getScore();
					game.setHighscore(highscore);
				}
				
			g.setColor(Color.CYAN);
			g.setFont(new Font("TimesRoman", Font.BOLD, 80));
			g.drawString("GAME OVER!!!", 135, 250);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString("Your Highscore is: " + highscore, 300, 275);
				
			CountDownLatch latch = new CountDownLatch(1);
			gO = new GameOverListener();
			gO.add(latch);
			win.addKeyListener(gO);
			latch.await();
			game.setScore(0);
			game.setLives(3);
			}
		} 
	}
}
