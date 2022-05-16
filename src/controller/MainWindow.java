package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import screens.Screen1;
//import javafx.scene.canvas.GraphicsContext;


public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;
	
	//private GraphicsContext gc;
	
	public static long FRAMES=0;
	private Screen1 screen;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		screen = new Screen1(canvas);
		canvas.setFocusTraversable(true);
		//gc = canvas.getGraphicsContext2D();
		new Thread(() -> {
			while (true) {
				paint();
				pause(50);
				FRAMES++;
			}
		}).start();
		
		
	}

	private void paint() {
		screen.paint();
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
