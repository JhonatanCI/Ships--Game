package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemie {
	
	private GraphicsContext gc;
	
	private int x;
	private int y;
	private Image image;
	private boolean life = true;
	
	public Enemie(Canvas canvas, int x, int y) {
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y=y;
		try {
			int i = (int)Math.floor(Math.random()*(6)+1);
				File file = new File("src/images/PNG_Parts&Spriter_Animation/Ship"+i+"/Ship"+i+".png");
				
				 image= new Image(new FileInputStream(file));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (life) {

			y+=3;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void paint() {
		gc.drawImage(image, x, y,40,65);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}
	
	
}
