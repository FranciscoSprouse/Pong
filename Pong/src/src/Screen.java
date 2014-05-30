package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener {

	private double x;
	private double y;
	private double dx;
	private double dy;
	private boolean movingLeft;
	private boolean movingDown;
	private int py;
	private int dpy;
	private Play game;
	
	public Screen (Play game) {
		x = 360;
		dx = 1;
		dy = 1;
		y = (int)(Math.random()*400+150);
		dpy =  70;
		movingLeft = true;
		movingDown = true;
		setOpaque(false);
		this.game=game;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		for(int i = 0; i < 550; i += 70) {
			g.fillRect(383 , 10 + i, 25, 50);
		} 
		g.setColor(Color.WHITE);
		g.fillOval((int)x, (int)y, 40, 40);
		g.fillRect(0, py, 30, 100);
		g.setColor(Color.GREEN);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("Score= " + game.getScore(), 50, 20);
		g.setColor(Color.RED);
		g.drawString("Lives= " + game.getLives(), 450, 20);
	}
	public void updateBall () {
		if (x >= getWidth() - 40) {
			movingLeft = true;
		}
		if(y <= 0) {
			movingDown = true;
		}
		else if(y >= getHeight() - 40) {
			movingDown = false;
		}
		if(movingLeft)
			x -= dx;
		else
			x += dx;
		if(movingDown)
			y += dy;
		else
			y -= dy;
		if(x <= 30 && y >= py - 40 && y <= py+100) {
			movingLeft = false;
			x = 30;
			dx+=.5;
			dy+=.2;
			game.setScore(game.getScore()+1);
		}
		if(x <= 0) {
			x = 360;
			y = (int)(Math.random()*400+150);
			dx = 1;
			dy = 1;
			game.setLives(game.getLives()-1);
			try{Thread.sleep(250);} catch (Exception e) {}
		}
		x = x >= getWidth() - 40 ? getWidth() - 40 : x;
		
	}
	@Override
	public void keyTyped(KeyEvent evt) {
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == 38) {
			dpy = Math.abs(dpy);
			if(py > 0)
				for(int i = 0; i < dpy; i++) {
					py--;
					repaint();
				}
		}
		else if(evt.getKeyCode() == 40) {
			dpy = -Math.abs(dpy);
			if(py + 100 < getHeight())
				for(int i = 0; i > dpy; i--) {
					py++;
					repaint();
				}
		}
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		
	}
}
