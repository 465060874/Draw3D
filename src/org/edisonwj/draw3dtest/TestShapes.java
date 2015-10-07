package org.edisonwj.draw3dtest;

import org.edisonwj.draw3d.Draw3D;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
*/
public class TestShapes extends Application {
	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestShapes");
		primaryStage.show();
	}
	
	private void buildData() {
		dt.setSequencingOn();
		dt.setPointLight(true);
		dt.setAmbientLight(false);
		
		dt.setDrawColor(Color.CADETBLUE);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawCone(8, 8, 0, 2, 3);
		
		dt.setDrawColor(Color.CADETBLUE);
		dt.setDrawMode(DrawMode.LINE);
		dt.drawCone(10, -3, 0, 2, 3);

		dt.setDrawColor(Color.CORNFLOWERBLUE);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawCylinder(-4, 8, 2, 2, 3);
		
		dt.setDrawColor(Color.CORNFLOWERBLUE);
		dt.setDrawMode(DrawMode.LINE);;
		dt.drawCylinder(-4, -2, 2, 2, 3);
		
		dt.setDrawColor(Color.TOMATO);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawCuboid(-7, 4, -5, 3, 4, 3);
		dt.drawLabel(-7, 4, -8, "Fill");
		
		dt.setDrawColor(Color.TOMATO);
		dt.setDrawMode(DrawMode.LINE);
		dt.setCullFace(CullFace.BACK);
		dt.drawCuboid(2, -2, -2.5, 2, 2.5, 2);
		dt.drawLabel(2, -2, -4.5, "No Fill, Cull None");
		
		dt.setDrawColor(Color.TOMATO);
		dt.setDrawMode(DrawMode.LINE);
		dt.setCullFace(CullFace.NONE);
		dt.drawCuboid(-3.5, -2, -6, 2, 2.5, 2);
		dt.drawLabel(-5, -2, -8, "No Fill, Cull Back");
		
		dt.setDrawColor(Color.GOLD);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawSphere(8, 8, -4, 2);
		
		dt.setDrawColor(Color.GOLD);
		dt.setDrawMode(DrawMode.LINE);
		dt.drawSphere(10, -3, -4, 2);
		
		dt.setDrawColor(Color.CRIMSON);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawOval(10, 7, 6, 3, 1, 45, 0, 0);
		
		dt.setDrawColor(Color.CRIMSON);
		dt.setDrawMode(DrawMode.LINE);
		dt.drawOval(4, -4, 8, 3, 1, 45, 0, 0);
		
		dt.setDrawColor(Color.DEEPPINK);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawRectangle(-4, 7, 6, 4, 2, -45, 0, 0);
		
		dt.setDrawColor(Color.DEEPPINK);
		dt.setDrawMode(DrawMode.LINE);
		dt.drawRectangle(-6, -4, 8, 4, 2,  -45, 0, 0);

	}
			
	public static void main(String[] args) {
		launch(args);
	}
}