package screens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Letters;


public class ScoreScreen extends BaseScreen{
	private ArrayList<Integer> scores;
	private int jump = 20;
	public ScoreScreen(Canvas canvas, int score) {
		super(canvas);
		scores = new ArrayList<Integer>();
		scores.add(score);
	}

	@Override
	public void paint() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		loadJSON();
		Collections.sort(scores,Collections.reverseOrder());
		new Letters(canvas,110,jump,"RANK").paint();
		new Letters(canvas,430,jump,"SCORE").paint();
		int l = 1;
		for(Integer i : scores) {
			jump+=20;
			new Letters(canvas,110,jump,l+"").paint();
			new Letters(canvas,430,jump,i+"").paint();
			l++;
		}
		saveJSON();
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveJSON() {
		Gson gson = new Gson();
		String json = gson.toJson(scores);
		System.out.println(json);
		File file = new File("data/data.json");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(json.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void loadJSON() {
		FileInputStream is;
		try {
			is = new FileInputStream(new File("data/data.json"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String json = "";
			String line;
			while((line = reader.readLine()) !=null) {
				json += line;
			}
			//String = Obj
			Gson gson = new Gson();
			Integer[] data = gson.fromJson(json, Integer[].class);
			
			
			for(Integer d : data) {
				scores.add(d);
			}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
