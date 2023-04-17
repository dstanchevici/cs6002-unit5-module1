
public class ColorImageExample {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	String filename = "redcirclesmall.png";
	int[][][] pixels = imTool.imageFileToPixels (filename);
	imTool.showImage (pixels, filename);

	// Print each color one by one.
	printImage (pixels, 1);
	printImage (pixels, 2);
	printImage (pixels, 3);

	// Count the number of red pixels:
	int r = countRed (pixels);
	System.out.println ("r=" + r);
    }

    static int countRed (int[][][] pixels)
    {
	int r = 0;
        for (int i=0; i<pixels.length; i++) {
	    for (int j=0; j<pixels[i].length; j++) {
		if ( pixels[i][j][1] >= 240 &&
		     pixels[i][j][2] < 240 &&
		     pixels[i][j][3] < 240) {
		    r++;
		}
		     
	    }
	}
	return r;
    }

    static void printImage (int[][][] pixels, int color)
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

    }
}
