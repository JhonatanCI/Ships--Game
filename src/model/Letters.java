package model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Letters {
	private Canvas canvas;
	private GraphicsContext gc;
	private String text;
	
	private int x,y;
	
	public Letters(Canvas canvas,int x,int y,String text) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		this.text=text;
	}
	
	public void paint() {
			gc.setFill(Color.WHITE);;
			gc.fillText(text,x,y);
	}
}
