import java.util.*;

public class Border2 {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	//String filename = "redcirclesmall.png";
	//String filename = "redcircle.png";
	String filename = "redshapessmall.png";
	int[][][] pixels = imTool.imageFileToPixels (filename);

	int[][][] pixels2 = copy (pixels);
	makeBorder (pixels2);

	imTool.showImage (pixels, filename);
	imTool.showImage (pixels2, "with border");
    }

    static void makeBorder (int[][][] pixels)
    {
	ArrayList<Coord> borderPixels = findBorderPixels (pixels);
	// After the border pixels are identified, set each of them to black.
	for (int i=0; i<borderPixels.size(); i++) {
	    Coord c = borderPixels.get (i);
	    pixels[c.row][c.col][1] = 0;
	    pixels[c.row][c.col][2] = 0;
	    pixels[c.row][c.col][3] = 0;
	}
    }

    static ArrayList<Coord> findBorderPixels (int[][][] pixels)
    {
	ArrayList<Coord> borderPixels = new ArrayList<>();

	int m = pixels.length;
	int n = pixels[0].length;

        for (int row=0; row<m; row++) {
	    for (int col=0; col<n; col++) {
		if ( isRed(pixels, row, col) ) {
		    if ( hasWhiteNeighbor(pixels, row, col) ) {
			Coord c = new Coord ();
			c.row = row;
			c.col = col;
			borderPixels.add (c);
		    }
		} // end-if isRed
	    } // end-for col
	} // end-for row	

	return borderPixels;
    }


    static boolean hasWhiteNeighbor (int[][][] pixels, int i, int j)
    {
	ArrayList<Coord> neighbors = getNeighbors (pixels, i, j);
	
        for (Coord c: neighbors) {
	    if ( isWhite(pixels, c.row, c.col) ) {
		return true;
	    }
	}	
	return false;
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


    static boolean isRed (int[][][] pixels, int i, int j)
    {
	/*
	return
	    pixels[i][j][1] >= 200 &&
	    pixels[i][j][2] < 200 &&
	    pixels[i][j][3] < 200;
	*/

	//  Tweaking what constitutes red for redshapessmall.png
	return
	    pixels[i][j][1] >= 250 &&
	    pixels[i][j][2] < 247 &&
	    pixels[i][j][3] < 247;
    }

    static boolean isWhite (int[][][] pixels, int i, int j)
    {
	return
	    pixels[i][j][1] >= 250 &&
	    pixels[i][j][2] >= 250 &&
	    pixels[i][j][3] >= 250;

    }

    static int[][][] copy (int[][][] pixels)
    {
	int[][][] pixelsCopy = new int[pixels.length][pixels[0].length][4];

	for (int i=0; i<pixels.length; i++) {
	    for (int j=0; j<pixels[0].length; j++) {
		for (int k=0; k<4; k++) {
		    pixelsCopy[i][j][k] = pixels[i][j][k];
		}
	    }
	}
	
	return pixelsCopy;

    }

    static void print (int[][][] pixels, int color)
    {
	int m = pixels.length;
	int n = pixels[0].length;
	System.out.println ("Image: #rows=" + m + " #cols=" + n + " color=" + color);

        for (int i=0; i<pixels.length; i++) {
	    for (int j=0; j<pixels[i].length; j++) {
		System.out.printf (" %3d", pixels[i][j][color]);
	    }
	    System.out.println ();
	}
    } // end-print
}
