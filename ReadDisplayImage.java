// Unit 5, Module 1, Ex. 1.0

public class ReadDisplayImage {

    public static void main (String[] argv)
    {
	ImageTool imTool = new ImageTool ();
	String filename = "redcirclesmall.png";
	int[][][] pixels = imTool.imageFileToPixels (filename);
	imTool.showImage (pixels, filename);
    }

}
