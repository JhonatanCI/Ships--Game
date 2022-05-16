package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		//System.out.println((((4*3)+(4*3)+(3.8*3)+(3.5*3)+(4*3)+(3*3))/18)+"");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainWindow.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

}
