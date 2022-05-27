package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Explosion {
	

		private Canvas canvas;
		private GraphicsContext gc;
		private Image[] explosions=  new Image[11];
		
		private int x,y;
		private int size;
		private int speed;
		private int frame = 0;
		private boolean die=false;
		
		public Explosion(Canvas canvas,int x,int y) {
			this.canvas = canvas;
			this.gc = canvas.getGraphicsContext2D();
			this.x = x;
			this.y = y;
			this.size = 60;
			this.speed = 3;
			for(int i = 0 ;i<11;i++) {
				File file = new File("src/images/PNG_Parts&Spriter_Animation/Explosions/Explosion1/Explosion1_"+(i+1)+".png");
				Image image;
				try {
					image = new Image(new FileInputStream(file));
					explosions[i]= image;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
		}
		
		public void paint() {
				gc.drawImage(explosions[frame], x, y,size,size);
				frame++;
				if(frame==11) {
					die = true;
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
		
		public boolean isDie() {
			return die;
		}
		
	

}
