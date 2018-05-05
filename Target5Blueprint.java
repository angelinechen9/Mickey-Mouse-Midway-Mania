package mickeymousemidwaymania;

import processing.core.PApplet;

public class Target5Blueprint {
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
	
	public Target5Blueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
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
		p.ellipse (x - 25, y - 25, length / 2, width / 2);
		p.ellipse (x + 25, y - 25, length / 2, width / 2);
		p.fill (0, 0, 255);
		p.triangle (x, y - 50, x - 25, y - 13, x + 25, y - 13);
		p.textSize (20);
		p.fill (255, 255, 255);
		p.text ("2000", x - 25, y);
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