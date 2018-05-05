package mickeymousemidwaymania;

import processing.core.PApplet;

public class ShooterBlueprint {
	PApplet p;
	
	// color
	public float r;
	public float g;
	public float b;
	
	// size
	public float length;
	public float width;
	
	// speed
	public float vx;
	
	// location
	public float x;
	public float y;
	
	public ShooterBlueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
			tempWidth, float tempVX, float tempR, float tempG, float tempB) {
		p = tempApp;
		x = tempX;
		y = tempY;
		length = tempLength;
		width = tempWidth;
		vx = tempVX;
		r = tempR;
		g = tempG;
		b = tempB;
	}
	
	public void display () {
		p.fill (r, g, b);
		p.rect (x, y, length, width);
	}
	
	public void drive() {
		x = p.mouseX;
	}
	
	public float getx() {
		return x;
	}
	
	public float gety() {
		return y;
	}
}