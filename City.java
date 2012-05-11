///
/// Contents: Demonstrate Euclidean TSP Programs
/// Author:   Jeff Parvin
/// Date:     27 March 2012
///

public class City {
	
	private String name;
	private double x;
	private double y;
	
	public City(String name, double x, double y){
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
