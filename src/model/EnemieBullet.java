package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemieBullet {
	private Canvas canvas;
	private GraphicsContext gc;
	private Image[] shots=  new Image[2];
	
	private int x,y;
	private int size;
	private int speed;
	private int frame = 0;
	
	public EnemieBullet(Canvas canvas,int x,int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		this.size = 60;
		this.speed = 4;
		File file1 = new File("src/images/PNG_Parts&Spriter_Animation/Shots/Shot1/shot1_exp2.png");
		File file2 = new File("src/images/PNG_Parts&Spriter_Animation/Shots/Shot1/shot1_exp3.png");
		try {
			Image image1= new Image(new FileInputStream(file1));
			Image image2= new Image(new FileInputStream(file2));
			shots[0] = image1;
			shots[1] = image2;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void paint() {
			gc.drawImage(shots[frame%2], x, y,size,size);
			frame++;
			y+=speed;

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
