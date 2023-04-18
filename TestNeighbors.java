import java.util.*;

// NOTE: you need to have Coord.java in the same directory.

public class TestNeighbors {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	String filename = "redcirclesmall.png";
	int[][][] pixels = imTool.imageFileToPixels (filename);
	int m = pixels.length;
	int n = pixels[0].length;

	// Top-left pixel: should print (1,0), (0,1) and (1,1)
	ArrayList<Coord> neighbors = getNeighbors (pixels, 0, 0);
	System.out.print ("Neighors of (0,0):");
	for (Coord c: neighbors) {
	    System.out.print (" (" + c.row + "," + c.col + ")");
	}
	System.out.println ();

	// Bottom-middle: 5 neighbors (13,10), (13,11), (14,11), (14,9), (13,9)
	neighbors = getNeighbors (pixels, m-1, n/2);
	System.out.print ("Neighors of (m-1,n/2):");
	for (Coord c: neighbors) {
	    System.out.print (" (" + c.row + "," + c.col + ")");
	}
	System.out.println ();

	// Center: should give 8 neighbors (6,10), (6,11), (7,11), (8,11),
	// (8,10), (8,9), (7,9), (6,9).
	neighbors = getNeighbors (pixels, m/2, n/2);
	System.out.print ("Neighors of (m/2,n/2):");
	for (Coord c: neighbors) {
	    System.out.print (" (" + c.row + "," + c.col + ")");
	}
	System.out.println ();

    }

    static ArrayList<Coord> getNeighbors (int[][][] pixels, int i, int j)
    {
	ArrayList<Coord> neighbors = new ArrayList<>();
	int m = pixels.length;
	int n = pixels[0].length;

	// Try 8 neighbors.

	// North: i-1
	if (i>0) {
	    Coord c = new Coord ();
	    c.row = i-1;
	    c.col = j;
	    neighbors.add (c);
	}
	// Northeast: i-1, j+1
	if ((i>0) && (j<n-1)) {
	    Coord c = new Coord ();
	    c.row = i-1;
	    c.col = j+1;
	    neighbors.add (c);
	}
	// East: i, j+1
	if (j<n-1) {
	    Coord c = new Coord ();
	    c.row = i;
	    c.col = j+1;
	    neighbors.add (c);
	}
	// Southeast: i+1, j+1
	if ((i<m-1) && (j<n-1)) {
	    Coord c = new Coord ();
	    c.row = i+1;
	    c.col = j+1;
	    neighbors.add (c);
	}
	// South: i+1, j
	if (i<m-1) {
	    Coord c = new Coord ();
	    c.row = i+1;
	    c.col = j;
	    neighbors.add (c);
	}
	// Southwest: i+1, j-1
	    if ((i<m-1) && (j>0)) {
	    Coord c = new Coord ();
	    c.row = i+1;
	    c.col = j-1;
	    neighbors.add (c);
	}
        // West: i, j-1
	if (j>0) {
	    Coord c = new Coord ();
	    c.row = i;
	    c.col = j-1;
	    neighbors.add (c);
	}
	// Northwest: i-1, j-1
	if ((i>0) && (j>0)) {
	    Coord c = new Coord ();
	    c.row = i-1;
	    c.col = j-1;
	    neighbors.add (c);
	}
	
	return neighbors;
    }


}
