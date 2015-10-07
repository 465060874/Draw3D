package org.edisonwj.draw3dtest;

import org.edisonwj.draw3d.Draw3D;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
* StudentBase class provides a template for students/teachers to use in creating
* programs to display three dimensional data. The user creates code in the buildData()
* method using the methods available in Draw3D for drawing lines, vectors, etc.
* 
* @author William Edison
* @version 1.01 August 2015
* 
*/
public class TestRoomScan extends Application {
	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestRoomScan");
		primaryStage.show();
	}
	
	private void buildData() {
		
		dt.setCumulate(false);
		dt.setYaxisUp(true);
		dt.setShowBoundaryCube(false);
		dt.setShowAxes(false);
		dt.setXYZRange(100,  100,  100);
		dt.setCamera(0.0,  -180.0,  -800.0);
		dt.setOriginView(-100, -100, -100);
		
		// Draw Grid
		dt.setLineRadius(.5);
		dt.setDrawColor(Color.GRAY);

		int hiboundX = 90;
		int loboundX = 10;
		int hiboundY = 60;
		int loboundY = 10;
		int cellsize = 5;

		for (int i=loboundX+cellsize; i<hiboundX; i=i+cellsize) {
			dt.drawLine(i, loboundY, 0, i, hiboundY, 0);
		}
		for (int i=loboundY; i < hiboundY; i=i+cellsize) {
			dt.drawLine(loboundX, i, 0, hiboundX, i, 0);
		}
		
		dt.setLineRadius(2);
		dt.setDrawColor(Color.BLACK);
		
		dt.drawLine(10, 10, 0, 90, 10, 0);
		dt.drawLine(90, 10 ,0, 90, 60, 0);
		dt.drawLine(90, 60, 0, 10, 60, 0);
		dt.drawLine(10, 60, 0, 10, 10, 0);
		
		dt.drawLine(40,  10,  0,  40,  50,  0);
		dt.drawLine(60,  60,  0,  60,  20,  0);
		dt.drawLine(90, 30, 0, 70, 30, 0);
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}