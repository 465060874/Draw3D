package org.edisonwj.draw3d;

import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
* Draws a series of point set values for a function z(x,y), defined below,
* as the parameter m varies from 0 to 1.0.
*
*/
public class AlgorithmF implements Algorithm {
	
	private int id;
	private double[] info;
	private int iterations = 10;
	private long delay = 500L;
	private final boolean clear = true;
	private final boolean drone = false;
    PhongMaterial tMaterial;
	
	public AlgorithmF() {
		System.out.println("Loaded: " + this.getClass().getName());
	}
	
	public Object processAlgorithm(int n) {
		
		double m = n * 1.0;
		double minx = -6.0;
		double maxx= 6.0;
		double miny = -6.0;
		double maxy = 6.0;
		double intv = .2;
		int sizex = (int)(((maxx - minx) / intv) + 1.0);
		int sizey = (int)(((maxy - miny) / intv) + 1.0);
		
		Point3D[] f = new Point3D[sizex * sizey];
		
		double x = minx-intv;
		for (int i = 0; i < sizex; i++) {
			x += intv;
			double y = miny-intv;
    		for (int j = 0; j < sizey; j++) {
    			y += intv;
    			double z = m * Math.cos(Math.pow(x*x + y*y, 0.5))/(2.0 + Math.pow(x*x + y*y, 0.5));
    			int k = i*sizey + j;
    			f[k] = new Point3D(x, y, z);
    		}
    	}
		return f;
	}
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double[] getInfo() {
		return info;
	}
	
	public void setInfo(double[] info) {
		this.info = info.clone();
	}
        
	public int getIterations() {
		return iterations;
	}
	
	public long getDelay() {
		return delay;
	}
	
	public boolean doClear() {
		return clear;
	}
	
	public boolean isDrone() {
		return drone;
	}
	
	public PhongMaterial getMaterial(int n) {
		tMaterial = new PhongMaterial();	
		tMaterial.setDiffuseColor(Color.CORAL);
	    tMaterial.setSpecularColor(Color.LIGHTCORAL);	
		return tMaterial;
	}
}