///
/// Contents: Demonstrate Euclidean TSP Programs
/// Author:   Jeff Parvin
/// Date:     27 March 2012
///

import java.awt.* ;
import javax.swing.* ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.Random ;

public class DemonstrateEuclideanTSP {

	public static int CITIES=1000, WIDTH=500, HEIGHT=500, WAIT=1000 ;

	public static void main(String[] args) {
		
		if(args.length == 0){
			System.out.println("Error: Need to enter command line argument for number of cities.");
			System.exit(0);
		}
		
		if(Integer.parseInt(args[0]) < 2){
			System.out.println("Error: Command line argument must be greater than 1.");
			System.exit(0);
		}
		
		//
		// Create cities:
		//
		CITIES = Integer.parseInt(args[0]) ;
		ArrayList<City> cities = randomCities(CITIES,WIDTH,HEIGHT) ;

		//
		// MST-walk algorithm:
		//
		ArrayList<Edge> MST = EuclideanTSP.MST(cities) ;
		ArrayList<City> MSTTour = EuclideanTSP.MSTTour(MST) ;
		System.out.println("MST weight: " + EuclideanTSP.weight(MST)) ;
		System.out.println("MST tour length: " + EuclideanTSP.length(MSTTour)) ;

		//
		// Create JFrame and map:
		//
		JFrame mstwalk_tour_frame = new JFrame("MST-Walk Tour") ;
		Map mstwalk_tour_map = new Map(WIDTH,HEIGHT,WIDTH,HEIGHT) ;
		mstwalk_tour_frame.getContentPane().add(mstwalk_tour_map) ;
		mstwalk_tour_frame.pack() ;
		mstwalk_tour_frame.setVisible(true) ;
		mstwalk_tour_frame.repaint() ;
		sleep(WAIT) ;

		//
		// Display cities:
		//
		mstwalk_tour_map.setCityColor(Color.blue) ;
		for (City c : cities) { 
			mstwalk_tour_map.city(c) ; 
		}
		sleep(5*WAIT) ;

		//
		// Display MST:
		//
		mstwalk_tour_map.setEdgeColor(Color.gray) ;
		for (int i=0 ; i<MST.size() ; i++) {
			mstwalk_tour_map.edge(MST.get(i)) ;
			//sleep(WAIT/10) ;
		}
		sleep(5*WAIT) ;

		//
		// Display MST-Walk:
		//
		mstwalk_tour_map.setEdgeColor(Color.red) ;
		for (int i=0 ; i<MSTTour.size()-1 ; i++) {
			mstwalk_tour_map.edge(new Edge(MSTTour.get(i),MSTTour.get(i+1))) ;
//			sleep(WAIT/15) ;
		}
		
//		sleep(15*WAIT) ;	// wait a little while
//		System.exit(0);		// close jframe

	}

	///
	/// Other Methods
	///

	public static ArrayList<City> smallCities() {
		ArrayList<City> result = new ArrayList<City>() ;
		result = new ArrayList<City>() ;
		result.add(new City("a",100.0,100.0)) ;
		result.add(new City("b",300.0,300.0)) ;
		result.add(new City("c",300.0,500.0)) ;
		result.add(new City("d",500.0,100.0)) ;
		result.add(new City("e",600.0,100.0)) ;
		result.add(new City("f",200.0,600.0)) ;
		result.add(new City("g",300.0,600.0)) ;
		return result ;
	}

	// Generate random cities method
	public static ArrayList<City> randomCities(int n, double maxX, double maxY) {
		Random r = new Random() ;
		ArrayList<City> result = new ArrayList<City>() ;
		for (int i=0 ; i<n ; i++) {
			result.add( new City("city"+i,r.nextDouble()*maxX,r.nextDouble()*maxY) ) ;
		}
		return result ;
	}

	public static void sleep(long milliseconds) {
		Thread thread = new Thread() ;
		try { 
			thread.sleep(milliseconds) ; 
		}
		catch (Exception e) {}
	}

}

/// End-of-File