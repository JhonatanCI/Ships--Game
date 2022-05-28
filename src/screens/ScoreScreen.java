package screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Letters;

public class ScoreScreen extends BaseScreen{
	
	public ScoreScreen(Canvas canvas, int score) {
		super(canvas);
	}

	@Override
	public void paint() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		new Letters(canvas,10,20,"RANK").paint();
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
