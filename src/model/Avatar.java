package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Avatar {
	
	private GraphicsContext gc;
	private int x=250;
	private int y=250;
	private Image image;
	
	public Avatar(Canvas c) {
		gc = c.getGraphicsContext2D();
		
		File file = new File("src/images/ship.png");
		//System.out.println(file.exists());
		try {
			image= new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void paint() {
		gc.drawImage(image, x, y);
		
		/*if(MainWindow.FRAMES == 20) {
			x=10;
			y=10;
		}*/
	}

	public void moveX(int i) {
		this.x+=i;
		
	}

	public void moveY(int i) {
		this.y+=i;
		
	}
}
