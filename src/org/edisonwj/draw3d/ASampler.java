package org.edisonwj.draw3d;

import org.edisonwj.draw3d.Draw3D;
import org.edisonwj.draw3d.Polygon3D;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
/**
* ASampler class provides examples of the various types of views that can be 
* created with Draw3D.
* 
* @author William Edison
* @version 1.00 July 2015
* 
*/

public class ASampler extends Application {

	private Draw3D dt;
	
	@Override
	public void start(Stage primaryStage) {
		dt = new Draw3D();
		Scene scene = dt.buildScene();
		buildData();
		dt.setStart();
		primaryStage.setScene(scene);
		primaryStage.setTitle("ASamplerOfBasicDrawingMethods");
		primaryStage.show();
	}
	
	private void buildData() {
		
		// Illustrate controls
		// #0
		dt.setSequencingOn();
		dt.setCumulate(false);
		dt.setAmbientLight(false);
		dt.setPointLight(true);
		dt.setDrawColor(Color.CORNFLOWERBLUE);
		dt.setDrawMode(DrawMode.FILL);
		dt.drawCylinder(8, 2, 4, 2, 3);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#0 Display controls");
		dt.setLabelFont(Font.font("Regular", 11));
		dt.drawLabel(-10, 2, 11, 180, 0, -18, "Press F (or space bar) to move foward through views");		
		dt.drawLabel(-10, 2, 10, 180, 0, -18, "Press B to move backward through views");
		dt.drawLabel(-10, 2,  9, 180, 0, -18, "Press keypad + or - to zoom in or out");
		dt.drawLabel(-10, 2,  8, 180, 0, -18, "Press arrow keys to move display");
		dt.drawLabel(-10, 2,  7, 180, 0, -18, "Use left mouse button to rotate display");
		dt.drawLabel(-10, 2,  6, 180, 0, -18, "Select Help Menu/Open Help Text for full description");
		
		// #1
		// Draw cumulative set of vectors
		double[] v1 = {2,  2, 2};
		double[] v2 = {2, -2, 2};
		double[] v3 = add(v1, v2);
		double[] v4 = crossProduct(v1, v2);
		
		dt.incrSequence();
		dt.setCumulate(false);
		dt.setAmbientLight(true);
		dt.setPointLight(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#1-4 Cumulative Display of Various Vectors");
		dt.setLabelFont(Font.font("Regular", 12));
		dt.setDrawColor(Color.CORAL);
		dt.drawVector(v1);
		dt.drawVector(v2);
		dt.drawLabel(1.6, 0.5, 0.5, 180, 0, 0, "Base Vectors");
		
		// #2
		dt.incrSequence();
		dt.setCumulate(true);
		dt.setDrawColor(Color.RED);
		dt.drawVector(v3);
		dt.drawLabel(v3[0], v3[1], v3[2], 180, 0, 0, "Vector Addition");
		
		// #3
		dt.incrSequence();
		dt.setDrawColor(Color.BLUE);
		dt.drawArrow(v1[0], v1[1], v1[2], v3[0], v3[1], v3[2]);
		dt.drawArrow(v2[0], v2[1], v2[2], v3[0], v3[1], v3[2]);
		dt.drawLabel((v2[0]+.4), v2[1], v2[2], 180,  0,  0,  "Complete Parallelogram");
		
		// #4
		dt.incrSequence();
		dt.setDrawColor(Color.GOLDENROD);
		dt.drawVector(v4);
		dt.drawLabel(v4[0], v4[1], v4[2], 180,  0,  0,  "Vector Cross Product");

		// Lines, Arrows, and Vectors
		// #5
		dt.incrSequence();
		dt.setCumulate(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#5 Lines, Arrows, and Vectors");

		dt.setAmbientLight(true);
		dt.setPointLight(false);

		dt.setDrawColor(Color.RED);
		
        dt.drawVector(5, 0, 5);
        dt.drawLine(1, 0, 0, 6, 0, 5);
        dt.drawArrow(2, 0, 0, 7, 0, 5);
        dt.drawVector(5, 0, -5);
        dt.drawLine(1, 0, 0, 6, 0, -5);
        dt.drawArrow(2, 0, 0, 7, 0, -5);  

        dt.drawVector(-5, 0, 5);
        dt.drawLine(-1, 0, 0, -6, 0, 5);
        dt.drawArrow(-2, 0, 0, -7, 0, 5);
        dt.drawVector(-5, 0, -5);
        dt.drawLine(-1, 0, 0, -6, 0, -5);
        dt.drawArrow(-2, 0, 0, -7, 0, -5);
   
        dt.setDrawColor(Color.BLUE);
        
        dt.drawVector(0, 5, 5);
        dt.drawLine(0, 1, 0, 0, 6, 5);
        dt.drawArrow(0, 2, 0, 0, 7, 5);    
        dt.drawVector(0, 5, -5);
        dt.drawLine(0, 1, 0, 0, 6, -5);
        dt.drawArrow(0, 2, 0, 0, 7, -5);

	    dt.drawVector(0, -5, 5);
	    dt.drawLine(0, -1, 0, 0, -6, 5);
	    dt.drawArrow(0, -2, 0, 0, -7, 5);    
	    dt.drawVector(0, -5, -5);
	    dt.drawLine(0, -1, 0, 0, -6, -5);
	    dt.drawArrow(0, -2, 0, 0, -7, -5);

		dt.setDrawColor(Color.MAGENTA);
		
	    dt.drawVector(5, 5, 5);
	    dt.drawLine(0, 0, 1, 5, 5, 6);
	    dt.drawArrow(0, 0, 2, 5, 5, 7);
	    dt.drawVector(-5, -5, 5);
	    dt.drawLine(0, 0, 1, -5, -5, 6);
	    dt.drawArrow(0, 0, 2, -5, -5, 7);
	    
	    dt.drawVector(5, 5, -5);
	    dt.drawLine(0, 0, -1, 5, 5, -6);
	    dt.drawArrow(0, 0, -2, 5, 5, -7);
	    dt.drawVector(-5, -5, -5);
	    dt.drawLine(0, 0, -1, -5, -5, -6);
	    dt.drawArrow(0, 0, -2, -5, -5, -7);
    
	    dt.setDrawColor(Color.SALMON);
	    
       	dt.drawArrow(-6, 6, 6, 6, 6, 6);
       	dt.drawArrow(6, 6, 6, 6, -6, 6);
       	dt.drawArrow(6, -6, 6, -6, -6, 6);
       	dt.drawArrow(-6, -6, 6, -6, 6, 6);
       	
       	dt.drawArrow(-6, 6, -6, 6, 6, -6);
       	dt.drawArrow(6, 6, -6, 6, -6, -6);
       	dt.drawArrow(6, -6, -6, -6, -6, -6);
       	dt.drawArrow(-6, -6, -6, -6, 6, -6);
       	       	
       	dt.drawArrow(0,  0,  6,  5,  5,  6);
       	dt.drawArrow(0,  0,  6,  5, -5,  6);
		
		// Draw variety of shapes
		// #6
		dt.incrSequence();
		dt.setCumulate(false);
		dt.setAmbientLight(false);
		dt.setPointLight(true);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#6 3D Shapes in Various Modes");
		dt.setLabelFont(Font.font("Regular", 10));
		
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
		
		dt.setDrawMode(DrawMode.FILL);
		dt.setCullFace(CullFace.NONE);
	
		// Draw vectors, lines, arrows of different sizes
		// #7
		dt.incrSequence();
		dt.setCumulate(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));;
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#7 Vectors, Lines, Arrows with Various Diameters");
		dt.setVectorRadius(.5);
		dt.setDrawColor(Color.RED);
		dt.drawVector(5, 0, 5);
		dt.drawVector(-5, 0, 5);
        dt.setDrawColor(Color.BLUE);
        dt.setLineRadius(1);
        dt.drawLine(1, 0, 0, 6, 0, 5);
        dt.drawLine(-1, 0, 0, -6, 0, 5); 
        dt.setDrawColor(Color.GREEN);
		dt.setArrowRadius(2);
        dt.drawArrow(2, 0, 0, 7, 0, 5);
        dt.drawArrow(-2, 0, 0, -7, 0, 5);
      
        // Draw Polygons
        // #8
        dt.incrSequence();
        dt.setCumulate(false);
		dt.setPointLight(false);
		dt.setAmbientLight(true);
        dt.setShowBoundaryCube(true);
        dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#8-9 Polygons with Bounding Box");
        dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", 12));;
		dt.drawLabel(-10, 2, -10, 180, 0, -18, "2D polygon in XY plane");
		Point3D[] p1 = {
				new Point3D( -5.00,  -2.6, 0.0),
				new Point3D( -0.75,  -5.0, 0.0),
				new Point3D(  6.00,  -4.0, 0.0),
				new Point3D(  5.00,   5.4, 0.0),
//				new Point3D(  2.00,   2.4, 0.0),
				new Point3D(  3.00,   7.0, 0.0),
				new Point3D( -5.00,   5.0, 0.0) };
		dt.setDrawColor(Color.LIGHTGRAY);
		dt.drawPolygon(p1);
		
		// #9
		dt.incrSequence();
		dt.setCumulate(true);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", 12));;
		dt.drawLabel(-10, 2, -12, 180, 0, -18, "2D polygon projected on 3D plane");
		Polygon3D p3d = new Polygon3D(p1);	// Uses none basic draw methods to project polygon
		p3d.setZ(4,  5,  6,  7);			// Project 2D polygon onto 3D plane 
		Point3D[] p1z = p3d.getV();
		dt.setDrawColor(Color.CORNFLOWERBLUE);
		dt.drawPolygon(p1z);
		
		// #10
		dt.incrSequence();
		dt.setCumulate(false);
		dt.setYaxisUp(true);
		dt.setShowBoundaryCube(false);
		dt.setShowAxes(false);
		dt.setCamera(0.0,  -180.0,  -800.0);
		dt.setOriginView(-100, -100, -100);
		dt.setDrawColor(Color.ANTIQUEWHITE);
		Point3D[] p = { new Point3D( 3.0, 1.4, 0),	// p0
						new Point3D( 5.1, 2.3, 0),	// p1
						new Point3D( 5.8, 3.8, 0),	// p2
						new Point3D( 5.4, 5.2, 0),	// p3
						new Point3D( 4.8, 6.1, 0),	// p4
						new Point3D( 3.6, 7.1, 0),	// p5
						new Point3D( 2.1, 5.7, 0),	// p6
						new Point3D( 1.4, 4.2, 0),	// p7
						new Point3D( 1.0, 3.0, 0),	// p8
						new Point3D( 1.0, 1.0, 0)	// p9
						};

		dt.drawPolygon(p, true, true, true);
        dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-6, 14, 0, 180, 0, 0, "#10 2D Polygon");
		dt.drawLabel(-4, 13, 0, 180, 0, 0, "Camera location set on Z axis with zero x and zero y angle");
		dt.drawLabel(-4, 12, 0, 180, 0, 0, "Origin (axis center) offset to (-100, -100, -100)");
	        
        // Draw planes
		// #11
        dt.incrSequence();
        dt.setDefaults();
        dt.setShowBoundaryCube(true);
        dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#11-12 Planes with Bounding Box");
        dt.setDrawColor(Color.LIGHTGREEN);
		dt.drawPlane(4,5,6,7);
		
		// #12
		dt.incrSequence();
		dt.setCumulate(true);
		dt.setDrawColor(Color.CORNFLOWERBLUE);
		dt.drawPlane(-4, 5, 6, 7);
		
		// Change XYZ Ranges
		// #13
		dt.incrSequence();
		dt.setDefaults();
		dt.setCumulate(false);
		dt.setAmbientLight(true);
		dt.setPointLight(false);
        dt.setXYZRange(1, 1, 1);
        dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-1.2, 0, 1.2 , 180, 0, -18, "#13 Change XYZ Ranges to -1 to 1");
		dt.drawLabel(-1.2, 0, 1.1 , 180, 0, -18, "(Ranges for X, Y, and Z can be different.)");
		dt.setDrawColor(Color.RED);
		dt.setArrowRadius(1);
		dt.drawArrow(0,0,.2,.6,0,.2);
		dt.setLabelFontSize(10);
		dt.drawLabel(.05, 0, .3 , 180, 0, 0, "Arrow: (0, 0, .2) to (.6, 0, .2)");

        // #14
        dt.incrSequence();
        dt.setXYZRange(100, 100, 100);
	    dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-120, 2, 120, 180, 0, -18, "#14 Change XYZ Ranges to -100 to 100");
		dt.setDrawColor(Color.RED);
		dt.drawArrow(0,0,40,60,0,40);
		dt.setLabelFontSize(10);
		dt.drawLabel(5, 0, 50 , 180, 0, 0, "Arrow: (0, 0, 40) to (60, 0, 40)");
		
        // #15
        dt.incrSequence();
        dt.setXYZRange(10, 10, 10);
	    dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-12, 2, 12, 180, 0, -18, "#15 Change XYZ Ranges to -10 to 10 (Default)");
		dt.setDrawColor(Color.RED);
		dt.drawArrow(0,0,6,6,0,6);
		dt.setLabelFontSize(10);
		dt.drawLabel(1, 0, 7 , 180, 0, 0, "Arrow: (0, 0, 6) to (6, 0, 6)");
        
        // Execute single animation
		// #16
		dt.incrSequence();
		dt.setDefaults();
        dt.setCumulate(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#16 Single Animation Example");
		dt.setLabelFont(Font.font("Regular", 12));
		dt.drawLabel(-10, 2, 10, 180, 0, -18, "Select Main Menu/Run Algorithm");
		dt.drawLabel(-10, 2,  9, 180, 0, -18, "    Select AlgorithmBezierOrderN3D.class");
		dt.drawLabel(-10, 2,  8, 180, 0, -18, "    or Select any other algorithm class file");
		dt.drawLabel(-10, 2,  7, 180, 0, -18, "(Algorithm execution will clear text)");
		
        // Execute multiple animations
		// #17
		dt.incrSequence();
        dt.setCumulate(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#17 Drone Annimation Example");
		dt.setLabelFont(Font.font("Regular", 12));
		dt.drawLabel(-10, 2, 10, 180, 0, -18, "Select Main Menu/Load AlgorithmS");
		dt.drawLabel(-10, 2,  9, 180, 0, -18, "    Select AlgorithmDrone1.class");
		dt.drawLabel(-10, 2,  8, 180, 0, -18, "Select Main Menu/Load AlgorithmS");
		dt.drawLabel(-10, 2,  7, 180, 0, -18, "    Select AlgorithmDrone2.class");
		dt.drawLabel(-10, 2,  6, 180, 0, -18, "Select Main Menu/Run AlgorithmS");
		dt.drawLabel(-10, 2,  5, 180, 0, -18, "Only two drone classes can be run at at time");
		dt.drawLabel(-10, 2,  4, 180, 0, -18, "  due to the drone communication setup.");
		dt.drawLabel(-10, 2,  3, 180, 0, -18, "Any number of non-drone algorithms can be run concurrently.");
		
		// Menu info
		// #18
		dt.incrSequence();
		dt.setDefaults();
		dt.setCumulate(false);
		dt.setShowAxes(false);
		dt.setShowBoundaryCube(false);
		dt.setDrawColor(Color.BLUE);
		dt.setLabelFont(Font.font("Regular", FontPosture.ITALIC,  14));
		dt.drawLabel(-10, 2, 12, 180, 0, -18, "#18 Menu Summary");
		dt.setLabelFont(Font.font("Regular", 12));
		dt.drawLabel(-8, 0, 10, 180, 0, -16, "Main Menu provides options:");
		dt.drawLabel(-8, 0,  9, 180, 0, -16, "    Open Files");
		dt.drawLabel(-8, 0,  8, 180, 0, -16, "    Load Data");
		dt.drawLabel(-8, 0,  7, 180, 0, -16, "    Load and Run Algorithm(S)");
		dt.drawLabel(-8, 0,  6, 180, 0, -16, "    Save Data");
		dt.drawLabel(-8, 0,  5, 180, 0, -16, "    Save Scene/SubScene Images");
		dt.drawLabel(-8, 0,  3, 180, 0, -16, "View Menu provides dynamic options to:");
		dt.drawLabel(-8, 0,  2, 180, 0, -16, "    Enable/Disable Axes Display");
		dt.drawLabel(-8, 0,  1, 180, 0, -16, "    Enable/Disable Tick Mark Display");
		dt.drawLabel(-8, 0,  0, 180, 0, -16, "    Z Axis Positive Up");
		dt.drawLabel(-8, 0, -1, 180, 0, -16, "    Y Axis Positive Up");
		dt.drawLabel(-8, 0, -2, 180, 0, -16, "    Enable/Disable Boundary Cube Display");
		dt.drawLabel(-8, 0, -3, 180, 0, -16, "    Enable/Disable Ambient Light");
		dt.drawLabel(-8, 0, -4, 180, 0, -16, "    Enable/Disable Point Light");
		dt.drawLabel(-8, 0, -6, 180, 0, -16, "Help Menu provides option to:");
		dt.drawLabel(-8, 0, -7, 180, 0, -16, "    Open Help Text File");
		dt.drawLabel(-8, 0, -8, 180, 0, -16, "    Help Text describes additional keyboard shortcuts");
		dt.drawLabel(-6, 0, -9, 180, 0, -16, "    and additional non-basic methods.");	
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
