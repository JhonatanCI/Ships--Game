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
	
	public Enemie(Canvas canvas, int x, int y) {
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y=y;
		File file = new File("src/images/ship.png");
		//System.out.println(file.exists());
		try {
			image= new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint() {
		gc.drawImage(image, x, y);
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
}
