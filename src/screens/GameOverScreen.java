package screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class GameOverScreen extends BaseScreen {
	private Image image;
	
	public GameOverScreen(Canvas canvas) {
		super(canvas);
		File file = new File("src/images/gameover.png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint() {
		gc.drawImage(image,0,0, canvas.getWidth(), canvas.getHeight());
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
