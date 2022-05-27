package screens;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;
import model.Enemie;
import model.Explosion;
import model.Score;
import model.Bullet;

public class Screen1 extends BaseScreen{

	
	private Avatar avatar;
	private boolean playing = true;
	private ArrayList<Bullet> bullets;
	private ArrayList<Explosion> explosions;
	private final int ENEMIES = 10;
	private Enemie[] enemies;
	private Score score = new Score(canvas,500,20);
	
	public Screen1(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
		bullets = new ArrayList<Bullet> ();
		explosions = new ArrayList<Explosion>();
		enemies = new Enemie[ENEMIES];
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
		for(Explosion e:explosions) {
			if(!e.isDie())
				e.paint();
			else {
				explosions.remove(e);
				return;
			}
		}
		for(Enemie b: enemies) {
			if(b!=null) {
				double disAvatar = Math.sqrt(Math.pow(b.getX()-(avatar.getX()-5), 2)+Math.pow(b.getY()-(avatar.getY()-30), 2));
				//System.out.println(disAvatar);
				if(disAvatar<=70) {
					playing = false;
					System.out.println("die");
				}
				for(Bullet p: bullets) {
					
					double enemieX=b.getX()-15;
					double enemieY=b.getY()+25;
					double disBUllet = Math.sqrt(Math.pow(enemieX-p.getX(), 2)+Math.pow(enemieY-p.getY(), 2));
					if(disBUllet<=20) {
						explosions.add(new Explosion(canvas,b.getX(),b.getY()));
						b.setLife(false);
						deleteEnemie(b);
						bullets.remove(p);
						return;
					}
				}
			}
		}
		
		score.paint(avatar.getScore());
		
	}
	
	

	private void deleteEnemie(Enemie b) {
		for(int i = 0; i<enemies.length;i++) {
			if(b==enemies[i]) {
				enemies[i] =null;
				avatar.setScore(avatar.getScore()+10);
				if(avatar.getScore()==(ENEMIES*10)) {
					playing=false;
				}
			}
		}
	}

	@Override
	public void onClick(MouseEvent e) {
		
	}

	@Override
	public void onKey(KeyEvent e) {
		
		if(e.getCode().equals(KeyCode.LEFT)) {
			avatar.moveX(-6);
		}
		
		if(e.getCode().equals(KeyCode.RIGHT)) {
			avatar.moveX(6);
		}
		if(e.getCode().equals(KeyCode.SPACE)) {
			bullets.add(new Bullet(canvas,avatar.getX()-5,avatar.getY()-40));
			//avatar.setState(1);
		}
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

}
