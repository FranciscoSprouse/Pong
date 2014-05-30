package src;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Background extends JPanel {

	public Background() {
		setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		for(int i = 0; i < 550; i += 70) {
			g.fillRect(383 , 10 + i, 25, 50);
		} 
	}
}
