
public class GreyScaleImage {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	String filename = "greycirclesmall.png";
	int[][] greyPixels = imTool.imageFileToGreyPixels (filename);
	imTool.showImage (greyPixels, filename);

	// 1. Print the number of rows and the number of columns.
	System.out.println ("numRows=" + greyPixels.length);
	System.out.println ("numColumns=" + greyPixels[0].length);

	int nonWhitePixels = 0;

	// 2. Then print the whole image
	for (int i=0; i<greyPixels.length; i++) {
	    for (int j=0; j<greyPixels[i].length; j++) {
		if (greyPixels[i][j] != 255) {
		    nonWhitePixels ++;
		}
		System.out.printf (" %3d", greyPixels[i][j]);
	    }
	    System.out.println ();
	}

	// 3. Count the number of non-white (not 255) pixels.
	System.out.println ("num of non-white pixels = " + nonWhitePixels);
    }

}
