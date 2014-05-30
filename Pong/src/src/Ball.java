package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private int x;
	private int y;
	private boolean movingLeft;
	private boolean movingDown;
	private Background back;
	
	public Ball () {
		x = 360;
		y = 260;
		movingLeft = true;
		movingDown = true;
		setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g) {
		/*g.setColor(Color.WHITE);
		for(int i = 0; i < 550; i += 70) {
			g.fillRect(383 , 10 + i, 25, 50);
		} */
		update();
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 40, 40);
	}
	public void update () {
		if(x == 0) {
			movingLeft = false;
		}
		else if (x >= getWidth() - 40) {
			movingLeft = true;
		}
		if(y == 0) {
			movingDown = true;
		}
		else if(y >= getHeight() - 40) {
			movingDown = false;
		}
		if(movingLeft)
			x--;
		else
			x++;
		if(movingDown)
			y++;
		else
			y--;
		System.out.println("x = " + x + " y= " + y + " movingLeft = " + movingLeft);
	}
}
