package model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Score {
	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x,y;
	
	public Score(Canvas canvas,int x,int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		
	}
	
	public void paint(int score) {
			gc.setFill(Color.WHITE);;
			gc.fillText("SCORE: "+score,x,y);
	}
}
