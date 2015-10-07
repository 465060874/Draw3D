package org.edisonwj.draw3d;

import javafx.scene.paint.PhongMaterial;
/**
 * Interface Algorithm needs to be implemented by any
 * algorithm that is to be executed by Draw3D.
 * 
 * The interface allows for implementation of computational animations specifying:
 * - number of iterations
 * - time delay between iterations in milliseconds
 * - material (color) value associated with each iteration
 * - color can also be embedded in the returned objects
 * - clear flag to preserve or clear the current view before displaying the new result
 * - for drones, setting and getting and object id and information on a paired drone
 * 
 * Either individual objects or an array of mixed typed objects can be returned to Draw3D for display.
 * Currently supported object types are:             
 *	-Arrow3D
 *	-Box3D
 *	-Cone3D
 *	-Cylinder3D
 *	-Drone3D
 *	-Line3D
 *	-Line3D[]
 *	-Oval3D
 *  -Mesh3D
 *	-Plane3D
 *	-Point3D
 *	-Point3D[]
 *	-Polygon3D
 *	-Rectangle3D
 *	-Sphere3D
 *	-Sphere3D[]
 *	-Text3D
 *	-Triangle3D
 *	-Vector3D
 * 
 * @author William Edison
 * @version 1.01 August 2015
 * 
 */
public interface Algorithm {
	
	public int getId();
	
	public void setId(int id);
	
	public double[] getInfo();
	
	public void setInfo(double[] info);

    public int getIterations();
    
    public long getDelay();
    
    public boolean doClear();
    
    public boolean isDrone();
    
    public PhongMaterial getMaterial(int iteration);
       
    public Object processAlgorithm(int iteration);
}