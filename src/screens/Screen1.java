package screens;

import java.util.ArrayList;

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
	private Enemie[] enemies;
	
	public Screen1(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
		bullets = new ArrayList<Bullet> ();
		enemies = new Enemie[30];
		createEnemies();
		
	}

	private void createEnemies() {
		int x = 20;
		int y = 0;
		int count = 0;
		int gir = 0;
		for(int i = 0; i<enemies.length;i++) {
			Enemie en = new Enemie(canvas,x,y);
			enemies[i] = en;
			new Thread(()->{
				en.run();
			}).start();
			count++;
			if(gir == 0) {
				if(count<7) {
					x+=80;
				}else{
					y+=60;
					x=0;
					count=0;
					gir=1;
				}
			}else {
				if(count<8) {
					x+=80;
				}else{
					y+=60;
					x=20;
					count=0;
					gir=0;
				}
			}
		}
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
		
		for(Enemie b: enemies) {
			if(b!=null)
			b.paint();
		}
		
		for(Enemie b: enemies) {
			if(b!=null)
			for(Bullet p: bullets) {
				double dis = Math.sqrt(Math.pow(b.getX()-p.getX(), 2)+Math.pow(b.getY()-p.getY(), 2));
				if(dis<=100) {
					b.setLife(false);
					deleteEnemie(b);
					bullets.remove(p);
					return;
				}
			}
		}
		
	}
	
	

	private void deleteEnemie(Enemie b) {
		for(int i = 0; i<enemies.length;i++) {
			if(b==enemies[i]) {
				enemies[i] =null;
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
			avatar.setState(1);
		}
	}

}
