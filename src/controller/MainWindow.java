package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import screens.GameOverScreen;
import screens.GameScreen;
//import javafx.scene.canvas.GraphicsContext;
import screens.ScoreScreen;


public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;
	
	//private GraphicsContext gc;
	
	public static long FRAMES=0;
	private GameScreen gameScreen;
	private GameOverScreen gameOver;
	private ScoreScreen scoreScreen;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameScreen = new GameScreen(canvas);
		gameOver = new GameOverScreen(canvas);
		canvas.setFocusTraversable(true);
		//gc = canvas.getGraphicsContext2D();
		new Thread(() -> {
			while (gameScreen.isPlaying()) {
				paint();
				pause(50);
				FRAMES++; 
			}
			gameOver.paint();
			pause(1000);
			scoreScreen = new ScoreScreen(canvas, gameScreen.getScore());
			scoreScreen.paint();
		}).start();
		
		initEvent();
	}

	private void paint() {
		gameScreen.paint();
	}
	
	private void initEvent() {
		
		canvas.setOnMouseClicked(e->{
			gameScreen.onClick(e);
			});
		
		canvas.setOnKeyPressed(e->{
			gameScreen.onKey(e);
		});
		
	}
	

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
