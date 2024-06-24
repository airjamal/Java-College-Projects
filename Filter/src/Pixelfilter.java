import java.awt.image.BufferedImage;

public abstract class Pixelfilter implements Filter {

	public BufferedImage process(String wert, BufferedImage ... image){
		int w = image[0].getWidth();
		int h = image[0].getHeight();

		int[] kopie = image[0].getRGB(0, 0, w, h, null, 0, w);
		int[] maskenKopie = null;
		if(image.length > 1 && image[1] != null){
			maskenKopie = image[1].getRGB(0, 0, w, h, null, 0, w);
		}

		for (int i = 0; i < kopie.length; i++) {
			if(maskenKopie == null || maskenKopie[i] > 0xFF000000){
				kopie[i] = calculate(kopie[i], wert);
			}
		}
		 
		image[0].setRGB(0, 0, w, h, kopie, 0, w);
		return image[0];
		
	}
		 
	 protected abstract int calculate(int pixelFarbe, String wert);
	 
}
