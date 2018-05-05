package mickeymousemidwaymania;

import processing.core.PApplet;

public class Target3Blueprint {
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
	
	public Target3Blueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
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
		p.ellipse (x - 35, y - 35, length / 2, width / 2);
		p.ellipse (x + 35, y - 35, length / 2, width / 2);
		p.fill (255, 0, 0);
		p.triangle (x - 35, y - 23, x - 35, y - 48, x, y - 35);
		p.fill (255, 0, 0);
		p.triangle(x + 35, y - 23, x + 35, y - 48, x, y - 35);
		p.fill (255, 0, 0);
		p.rect (x - 5, y - 40, 13, 13);
		p.textSize (20);
		p.fill (255, 255, 255);
		p.text ("500", x - 23, y);
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