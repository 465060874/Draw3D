package org.edisonwj.draw3d;

import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
/**
*
* @author William Edison
* @version 1.00 July 2015
* 
* Draws a drone moving on a vertical path.
*
*/
public class AlgorithmDrone1 implements Algorithm {
	
	private int id;
	private double[] info;
	private int iterations = 200;
	private long delay = 50;
	private final boolean clear = true;
	private final boolean drone = true;
	private PhongMaterial vMaterial;
	
	private long time;
	private long timeOld;
	private Point3D location;
	private Point3D locationOld;
	
	public AlgorithmDrone1() {
		System.out.println("loaded algorithm " + this.getClass().getName());
	}
	
	public Object processAlgorithm(int n) {

		double x = -5.0;
		double y = 5.0;
		double z = -10.0 + n*20.0/iterations;
		Drone3D d = new Drone3D(x, y, z, 48, 8, 0, 0, 0,
				new PhongMaterial(Color.BLUE),
				new PhongMaterial(Color.BLACK));
		d.setId(this.id);
    	return d;

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
		time = System.currentTimeMillis();
		location = new Point3D(info[1], info[2], info[3]);
		if (locationOld != null) {
			double distance = location.distance(locationOld);
			double elapsed = time - timeOld;
			double speed = distance/elapsed;
			System.out.printf(
					"time: %14d, drone: %2d, for drone: %2d, " +
					"location x= %6.4f, y= %6.4f, z= %6.4f, " +
					"distance= %8.4f, elapsed= %4.2f, speed= %6.4f\n",
					time, id, (int)info[0],
					location.getX(), location.getY(), location.getZ(),
					distance, elapsed, speed );
		}
		locationOld = location;
		timeOld = time;
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
		return vMaterial;
	}
}