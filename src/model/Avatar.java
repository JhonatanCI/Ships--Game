package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Avatar {
	
	private GraphicsContext gc;
	private int x=250;
	private int y=310;
	private ArrayList<Image> runImages;
	private ArrayList<Image> attackImages;
	//private int state = 0;
	//private int frame = 0;
	private Image image;
	private int score = 0;
	
	public Avatar(Canvas c) {
		gc = c.getGraphicsContext2D();
		runImages = new ArrayList<>();
		attackImages = new ArrayList<>();
		try {
				File file = new File("src/images/ship.png");
				
				 image= new Image(new FileInputStream(file));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(file.exists());
		
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
		/*if(state==0) {
			gc.drawImage(runImages.get(frame%10), x, y,100,100);
			frame++;
		}else {
			
			gc.drawImage(attackImages.get(frame), x, y,100,100);
			frame++;
			
			if(frame==10) 
				this.state=0;
		}
		*/
		gc.drawImage(image, x, y,50,70);
		
		/*if(MainWindow.FRAMES == 20) {
			x=10;
			y=10;
		}*/
	}
	
	/*public void setState(int state) {
		this.state=state;
		this.frame=0;
	}*/
	

	public void moveX(int i) {
		this.x+=i;
		
	}

	public void moveY(int i) {
		this.y+=i;
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
