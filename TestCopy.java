
public class TestCopy {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	String filename = "redcirclesmall.png";
	int[][][] pixels = imTool.imageFileToPixels (filename);
	int[][][] pixels2 = copy (pixels);
	imTool.showImage (pixels, filename);
	imTool.showImage (pixels2, "copy");

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

}
