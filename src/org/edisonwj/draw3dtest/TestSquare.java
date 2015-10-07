package org.edisonwj.draw3dtest;

import org.edisonwj.draw3d.Draw3D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
*/
public class TestSquare extends Application {
	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestSquare");
		primaryStage.show();
	}
	
	private void buildData() {
		dt.setAmbientLight(false);
		dt.setPointLight(true);
		dt.setShowAxes(false);
		dt.setShowBoundaryCube(false);
		
		dt.setDrawColor(Color.CRIMSON);
		dt.drawSquare(3, 0, 0, 2, 90, 0, 0);
		dt.drawSquare(-3, 0, 0, 2, 90, 0, 0);
		dt.drawSquare(3, 0,  6,  2, 90, 0, 0);
		dt.drawSquare(-3, 0, 6, 2, 90, 0, 0);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}