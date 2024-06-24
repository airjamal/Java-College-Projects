import java.awt.image.BufferedImage;

public interface Filter {
	
	 BufferedImage process(String wert,BufferedImage ... image);
	 
}