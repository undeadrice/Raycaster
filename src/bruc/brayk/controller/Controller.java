package bruc.brayk.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bruc.brayk.window.Window;

public class Controller implements KeyListener {

	private Window window;

	private boolean wPressed;
	private boolean aPressed;
	private boolean sPressed;
	private boolean dPressed;
	
	private boolean qPressed;
	private boolean ePressed;

	public Controller(Window window) {
		this.window = window;
		window.addKeyListener(this);
	}

	public boolean iswPressed() {
		return wPressed;
	}

	public void setwPressed(boolean wPressed) {
		this.wPressed = wPressed;
	}

	public boolean isaPressed() {
		return aPressed;
	}

	public void setaPressed(boolean aPressed) {
		this.aPressed = aPressed;
	}

	public boolean issPressed() {
		return sPressed;
	}

	public void setsPressed(boolean sPressed) {
		this.sPressed = sPressed;
	}

	public boolean isdPressed() {
		return dPressed;
	}

	public void setdPressed(boolean dPressed) {
		this.dPressed = dPressed;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		switch (arg0.getKeyChar()) {
		case 'w':
			setwPressed(true);
			break;
		case 'a':
			setaPressed(true);
			break;
		case 's':
			setsPressed(true);
			break;
		case 'd':
			setdPressed(true);
			break;
		case 'q':
			setqPressed(true);
			break;
		case 'e':
			setePressed(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyChar()) {
		case 'w':
			setwPressed(false);
			break;
		case 'a':
			setaPressed(false);
			break;
		case 's':
			setsPressed(false);
			break;
		case 'd':
			setdPressed(false);
			break;
		case 'q':
			setqPressed(false);
			break;
		case 'e':
			setePressed(false);
			break;
		}


	}

	public boolean isqPressed() {
		return qPressed;
	}

	public void setqPressed(boolean qPressed) {
		this.qPressed = qPressed;
	}

	public boolean isePressed() {
		return ePressed;
	}

	public void setePressed(boolean ePressed) {
		this.ePressed = ePressed;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
