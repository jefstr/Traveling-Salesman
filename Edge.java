///
/// Contents: Demonstrate Euclidean TSP Programs
/// Author:   Jeff Parvin
/// Date:     27 March 2012
///

public class Edge {
	
	// holds start city and end city of edge
	private City start;
	private City end;
	
	public Edge(City start, City end){
		this.start = start;
		this.end = end;
	}
	
	public City getStart(){
		return start;
	}
	
	public City getEnd(){
		return end;
	}
}
