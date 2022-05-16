package screens;

import java.util.ArrayList;

import controller.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;
import model.Enemie;
import model.Bullet;

public class Screen1 extends BaseScreen{

	
	private Avatar avatar;
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemie> boxes;
	
	public Screen1(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
		bullets = new ArrayList<Bullet> ();
		boxes = new ArrayList<Enemie> ();
		boxes.add(new Enemie(canvas,200,0));
	}

	@Override
	public void paint() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		avatar.paint();
		
		for(Bullet b: bullets) {
			b.paint();
			if(b.getX()>canvas.getWidth())
				bullets.remove(b);
		}
		
		for(Enemie b: boxes) {
			b.paint();
		}
		
		for(Enemie b: boxes) {
			for(Bullet p: bullets) {
				double dis = Math.sqrt(Math.pow(b.getX()-p.getX(), 2)+Math.pow(b.getY()-p.getY(), 2));
				if(dis<=100) {
					boxes.remove(b);
					bullets.remove(p);
					return;
				}
			}
		}
		
	}

	@Override
	public void onClick(MouseEvent e) {
		
	}

	@Override
	public void onKey(KeyEvent e) {
		
		if(e.getCode().equals(KeyCode.A)) {
			avatar.moveX(-2);
		}
		
		if(e.getCode().equals(KeyCode.W)) {
			avatar.moveY(-2);
		}
		if(e.getCode().equals(KeyCode.S)) {
			avatar.moveY(2);
		}
		if(e.getCode().equals(KeyCode.D)) {
			avatar.moveX(2);
		}
		if(e.getCode().equals(KeyCode.SPACE)) {
			bullets.add(new Bullet(canvas,avatar.getX(),avatar.getY()));
			try {
				Thread.sleep(80);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
