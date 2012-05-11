///
/// Contents: Demonstrate Euclidean TSP Programs
/// Author:   Jeff Parvin
/// Date:     27 March 2012
///

import java.awt.* ;
import javax.swing.* ;

public class Map extends JPanel{
	private int maxX;
	private int maxY;
	private int width;
	private int height;
	
	public Color edgeColor;
	public Color cityColor;
	
	public Map(int maxX, int maxY, int width, int height){
		this.maxX = maxX;
		this.maxY = maxY;
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(width,height)) ;
	}
	
	public void setCityColor(Color color){
		cityColor = color;
	}
	
	public void setEdgeColor(Color color){
		edgeColor = color;
	}
	
	//edge method - draw line
	
	public void edge(Edge edge){
		City start = edge.getStart();
		City end = edge.getEnd();
		
		Graphics g = getGraphics();
		g.setColor(edgeColor);
		g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
	}

	//city method - draw oval
	
	public void city(City city){
		Graphics g = getGraphics();
		g.setColor(cityColor);
		g.fillOval((int)city.getX(), (int)city.getY(), 5, 5);
	}
	
}
