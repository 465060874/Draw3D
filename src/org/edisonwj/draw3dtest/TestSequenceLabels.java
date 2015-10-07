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
public class TestSequenceLabels extends Application {
	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestSequenceLabels");
		primaryStage.show();
	}
	
	private void buildData() {
		
		dt.setAmbientLight(true);
		dt.setPointLight(false);
		dt.setCumulate(true);

		double[] v1 = {2,  2, 2};
		double[] v2 = {2, -2, 2};
		double[] v3 = add(v1, v2);
		double[] v4 = crossProduct(v1, v2);
		
		dt.setSequencingOn();
		dt.setDrawColor(Color.CORAL);
		dt.drawVector(v1);
		dt.drawVector(v2);
		dt.drawLabel(1.6, 0.5, 0.5, 180, 0, 0, "Base Vectors");
		
		dt.incrSequence();
		dt.setDrawColor(Color.RED);
		dt.drawVector(v3);
		dt.drawLabel(v3[0], v3[1], v3[2], 180, 0, 0, "Vector Add");
		
		dt.incrSequence();
		dt.setDrawColor(Color.BLUE);
		dt.drawArrow(v1[0], v1[1], v1[2], v3[0], v3[1], v3[2]);
		dt.drawArrow(v2[0], v2[1], v2[2], v3[0], v3[1], v3[2]);
		dt.drawLabel((v2[0]+.4), v2[1], v2[2], 180,  0,  0,  "Complete Parallelogram");
		
		dt.incrSequence();
		dt.setDrawColor(Color.GOLDENROD);
		dt.drawVector(v4);
		dt.drawLabel(v4[0], v4[1], v4[2], 180,  0,  0,  "Vector Cross Product");
		
		dt.incrSequence();
		dt.setDrawColor(Color.TURQUOISE);
		dt.drawLine(2,  5,  5,  5,  2,  5);
		dt.drawLine( 2,  5,  5,  2,  5,  0);
		dt.drawLine(5,  2,  5,  5,  2,  0);
		dt.drawLine( 0,  5,  0,  2,  5,  0);
		dt.drawLine(5,  0,  0,  5,  2,  0);
		dt.drawLine( 0,  2,  0,  5,  2,  0);
		dt.drawLine(2,  0,  0,  2,  5,  0);
		dt.drawLine(2,  5,  5,  0,  0,  5);
		dt.drawLine( 5,  2,  5,  0,  0,  5);
		//
		dt.drawLine( -2,  5,  5, -5,  2,  5);
        dt.drawLine( -2,  5,  5, -2,  5,  0);
		dt.drawLine(-5,  2,  5, -5,  2,  0);
		dt.drawLine(  0,  5,  0, -2,  5,  0);
		dt.drawLine( -5,  0,  0, -5,  2,  0);
		dt.drawLine(  0,  2,  0, -5,  2,  0);
		dt.drawLine(-2,  0,  0, -2,  5,  0);
		dt.drawLine( -2,  5,  5,  0,  0,  5);
		dt.drawLine( -5,  2,  5,  0,  0,  5);
		dt.drawLine(  2,  5,  5, -2,  5,  5);
	}
	
	public double[] add(double[] v1, double[] v2) {
		double[] v3 = new double[3];
		v3[0] = v1[0] + v2[0];
		v3[1] = v1[1] + v2[1];
		v3[2] = v1[2] + v2[2];
		return v3;
	}
	
	public double[] crossProduct(double[] v1, double[] v2) {
		double[] v3 = new double[3];
		v3[0] = v1[1] * v2[2] - v1[2] * v2[1];
		v3[1] = v1[2] * v2[0] - v1[0] * v2[2];
		v3[2] = v1[0] * v2[1] - v1[1] * v2[0];      
		return v3;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
