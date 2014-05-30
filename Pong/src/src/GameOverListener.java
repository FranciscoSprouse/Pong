package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CountDownLatch;

public class GameOverListener implements KeyListener {

	private CountDownLatch latch;

	public GameOverListener () {
		//
	}
	public void add(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		latch.countDown();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
