package org.edisonwj.draw3dtest;

import org.edisonwj.draw3d.Cone3D;
import org.edisonwj.draw3d.Cylinder3D;
import org.edisonwj.draw3d.Draw3D;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
*/
public class TestCone extends Application {
	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestCone");
		primaryStage.show();
	}
	
	private void buildData() {
		dt.setAmbientLight(false);
		dt.setPointLight(true);
		
		Cone3D cu3d = new Cone3D(0, 0, 0, 1, 2, 0, 0, 0, new PhongMaterial(Color.CORNFLOWERBLUE));
		cu3d.setConeDivisions(8);
		dt.drawCone3D(cu3d);
		
		Cylinder3D cy3d = new Cylinder3D(-5, 0, 0, 1, 2, 0, 0, 0, new PhongMaterial(Color.SALMON));
		cy3d.setCylinderDivisions(8);
		dt.drawCylinder3D(cy3d);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}