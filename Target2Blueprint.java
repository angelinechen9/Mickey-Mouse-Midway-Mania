package mickeymousemidwaymania;

import processing.core.PApplet;

public class Target2Blueprint {
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
	public float vy;
	
	// location
	public float x;
	public float y;
	
	public Target2Blueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
			tempWidth, float tempVX, float tempVY, float tempR, float tempG, float tempB) {
		p = tempApp;
		x = tempX;
		y = tempY;
		length = tempLength;
		width = tempWidth;
		vx = tempVX;
		vy = tempVY;
		r = tempR;
		g = tempG;
		b = tempB;
	}
	
	public void display () {
		p.fill (r, g, b);
		p.ellipse (x, y, length, width);
		p.ellipse (x - 50, y - 50, length / 2, width / 2);
		p.ellipse (x + 50, y - 50, length / 2, width / 2);
		p.textSize (20);
		p.fill (255, 255, 255);
		p.text ("200", x - 20, y);
	}
	
	public void drive() {
		x = x + vx;
		y = y + vy;
	}
	
	public float getx() {
		return x;
	}
	
	public float gety() {
		return y;
	}
	
	public float getvx() {
		return vx;
	}
	
	public float getvy() {
		return vy;
	}
}