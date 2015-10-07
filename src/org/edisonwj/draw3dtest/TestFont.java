package org.edisonwj.draw3dtest;

import org.edisonwj.draw3d.Draw3D;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
*/
public class TestFont extends Application {
	private Draw3D dt;
		
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestFont");
		primaryStage.show();
	}
	
	private void buildData() {
			    
		dt.setShowBoundaryCube(false);
		
		dt.setLabelFontSize(10);
		dt.drawLabel(4, 8, -2, "Test Text 1");
		
		dt.setLabelFontSize(12);
		dt.drawLabel(4, 8, -4, "Test Text 2");
		
		dt.setLabelFontSize(14);
		dt.drawLabel(4, 8, -6, "Test Text 3");
		
		dt.setLabelFontSize(16);
		dt.drawLabel(4, 8, -8, "Test Text 4");
		
		dt.setLabelFont(Font.font ("Regular", 16));
		dt.drawLabel(-4, 8, -2, "Test Text 5");
		
		dt.setLabelFont(Font.font ("Arial", 16));
		dt.drawLabel(-4, 8, -4, "Test Text 6");
		
		dt.setLabelFont(Font.font ("Verdana", 16));
		dt.drawLabel(-4, 8, -6, "Test Text 7");
		
		dt.setLabelFont(Font.font ("Times New Roman", 16));
		dt.drawLabel(-4, 8, -8, "Test Text 8");

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}