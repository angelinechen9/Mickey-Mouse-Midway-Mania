package mickeymousemidwaymania;

import java.util.ArrayList;

import processing.core.PApplet;

public class MickeyMouseMidwayMania extends PApplet {
	
	Target1Blueprint target1 = new Target1Blueprint (this, -100, 300, 100, 100, 0, 0, 0, 0, 0, 100);
	Target3Blueprint target3 = new Target3Blueprint (this, -100, 200, 75, 75, 3, 0, 0, 0, 0);
	Target4Blueprint target4 = new Target4Blueprint (this, -100, 100, 50, 50, 5, 0, 0, 0, 0);
	Target5Blueprint target5 = new Target5Blueprint (this, -100, 100, 50, 50, 5, 0, 0, 0, 0);
	ShooterBlueprint shooter = new ShooterBlueprint (this, mouseX, 400, 25, 100, 0, 0, 0, 255);
	BulletBlueprint bullet = new BulletBlueprint (this, mouseX, 400, 25, 25, 0, 3, random(100, 255), random(100, 255), random(100, 255));;
	ArrayList<Target1Blueprint> a = new ArrayList<Target1Blueprint>();
	ArrayList<Target3Blueprint> c = new ArrayList<Target3Blueprint>();
	ArrayList<Target4Blueprint> d = new ArrayList<Target4Blueprint>();
	ArrayList<Target5Blueprint> e = new ArrayList<Target5Blueprint>();
	ArrayList<BulletBlueprint> f = new ArrayList<BulletBlueprint>();
	int time1 = 0;
	int time2 = 0;
	int time3 = 0;
	int oldtime1 = 0;
	int oldtime2 = 0;
	int oldtime3 = 0;
	int newtime, oldtime;
	int bulletDelay = 10;
	int score = 0;

	public void setup() {
		size (500, 500);
		background (255, 255, 255);
	}

	public void draw() {
		fill (255, 255, 255);
		rect (0, 0, width, height);
		background (255, 255, 255);
		textSize (50);
		fill (0, 0, 0);
		text ("Mickey Mouse", 75, 250);
		textSize (50);
		fill (0, 0, 0);
		text ("Midway Mania", 75, 300);
		textSize (20);
		fill (0, 0, 0);
		text ("Move Shooter to Shoot Targets with Bullets", 50, 325);
		textSize (20);
		fill (0, 0, 0);
		text ("Shoot as Much as You Want", 100, 350);
		textSize (20);
		fill (0, 0, 0);
		text ("Some Targets Are Worth More Points than Others", 15, 375);
		textSize (20);
		fill (0, 0, 0);
		text ("Score: " + (score), 200, 25);
		shooter.display();
		shooter.drive();
		if (mousePressed) {
			bullet.display();
			bullet.drive();
			bulletDelay -= 1;
			if (bulletDelay <= 0) {
				f.add(new BulletBlueprint (this, mouseX, 450, 25, 25, 0, 3, 
						random(100, 255), random(100, 255), random(100, 255)));
				bulletDelay = 15;
			}
		}
		updatetargeta1();
		updatetarget3();
		updatetarget4();
		updatetarget5();
		updatebullet();
		time1 = millis();
		time2 = millis();
		time3 = millis();
		newtime = millis();
		
		if (newtime - oldtime > 600) {
			int ss = 100;
			if (random(1, 100) > 75)
				ss = 200;
			a.add(new Target1Blueprint (this, -100, 300, 100, 100, 3, 0, 0, 0, 0, ss));
			oldtime = newtime;
		}

		if (time1 - oldtime1 > 1000) {
			c.add(new Target3Blueprint (this, -100, 200, 75, 75, 3, 0, 0, 0, 0));
			oldtime1 = time1;
		}
		
		if (time3 - oldtime3 > 6000) {
			e.add(new Target5Blueprint (this, -100, 100, 50, 50, 5, 0, 0, 0, 0));
			oldtime2 = time2;
			oldtime3 = time3;
		}
		
		if (time2 - oldtime2 > 3000) {
			d.add(new Target4Blueprint (this, -100, 100, 50, 50, 5, 0, 0, 0, 0));
			oldtime2 = time2;
		}
		
		if (millis() > 55000) {
			textSize (20);
			fill (0, 0, 0);
			text ("" + (60 - (millis() / 1000)), 250, 75);
		}
		
		if (millis() > 60000) {
			noLoop();
			if (score >= 0 && score <= 10000) {
				textSize (20);
				fill (0, 0, 0);
				text ("Level 1", 225, 50);
			}
			
			if (score >= 10001 && score <= 20000) {
				textSize (20);
				fill (0, 0, 0);
				text ("Level 2", 225, 50);
			}
			
			if (score >= 20001 && score <= 30000) {
				textSize (20);
				fill (0, 0, 0);
				text ("Level 3", 225, 50);
			}
			
			if (score >= 30001 && score <= 49999) {
				textSize (20);
				fill (0, 0, 0);
				text ("Level 4", 225, 50);
			}
			
			if (score > 49999) {
				textSize (20);
				fill (0, 0, 0);
				text ("Level 5", 225, 50);
			}
		}
	}
	
	private void updatetargeta1() {
		for (int i = 0; i < a.size(); i++) {
			target1 = a.get(i);
			target1.display();
			target1.drive();
		}
	}
		
	private void updatetarget3() {
		for (int i = 0; i < c.size(); i++) {
			target3 = c.get(i);
			target3.display();
			target3.drive();
		}
	}
	
	private void updatetarget4() {
		for (int i = 0; i < d.size(); i++) {
			target4 = d.get(i);
			target4.display();
			target4.drive();
		}
	}
	
	private void updatetarget5() {
		for (int i = 0; i < e.size(); i++) {
			target5 = e.get(i);
			target5.display();
			target5.drive();
		}
	}
	
	private void updatebullet() {
		for (int i = 0; i < f.size(); i++) {
			bullet = f.get(i);
			if (bullet.y < 0) {
				f.remove(i);
			}
			else {
				bullet.display();
				bullet.drive();
				hittarget1();
				hittarget3();
				hittarget4();
				hittarget5();
			}
		}
	}
	
	private void hittarget1() {
		float width_2, length_2;
		for (int i = 0; i < a.size(); i++) {
			target1 = a.get(i);
			width_2 = target1.width/2;
			length_2 = target1.length/2;
			if (bullet.getx() > (target1.getx() - width_2) 
					&& bullet.getx() < (target1.getx() + width_2) 
					&& bullet.gety() < (target1.gety() + length_2)
					&& bullet.gety() > (target1.gety() - length_2)) {
				a.remove(i);
				bullet.y = -1;
				score += target1.score;
			}
		}
	}

	private void hittarget3() {
		float width_2, length_2;
		for (int i = 0; i < c.size(); i++) {
			target3 = c.get(i);
			width_2 = target3.width/2;
			length_2 = target3.length/2;
			if (bullet.getx() > (target3.getx() - width_2) 
					&& bullet.getx() < (target3.getx() + width_2) 
					&& bullet.gety() < (target3.gety() + length_2)
					&& bullet.gety() > (target3.gety() - length_2)) {
				c.remove(i);
				bullet.y = -1;
				score += 500;
			}
		}
	}
	
	private void hittarget4() {
		float width_2, length_2;
		for (int i = 0; i < d.size(); i++) {
			target4 = d.get(i);
			width_2 = target4.width/2;
			length_2 = target4.length/2;
			if (bullet.getx() > (target4.getx() - width_2) 
					&& bullet.getx() < (target4.getx() + width_2) 
					&& bullet.gety() < (target4.gety() + length_2)
					&& bullet.gety() > (target4.gety() - length_2)) {
				d.remove(i);
				bullet.y = -1;
				score += 1000;
			}
		}
	}
	
	private void hittarget5() {
		float width_2, length_2;
		for (int i = 0; i < e.size(); i++) {
			target5 = e.get(i);
			width_2 = target5.width/2;
			length_2 = target5.length/2;
			if (bullet.getx() > (target5.getx() - width_2) 
					&& bullet.getx() < (target5.getx() + width_2) 
					&& bullet.gety() < (target5.gety() + length_2)
					&& bullet.gety() > (target5.gety() - length_2)) {
				e.remove(i);
				bullet.y = -1;
				score += 2000;
			}
		}
	}
	
}