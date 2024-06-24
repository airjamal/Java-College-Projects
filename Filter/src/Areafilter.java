import java.awt.image.BufferedImage;

public abstract class Areafilter implements Filter {

public BufferedImage process(String wert, BufferedImage ... image){
		
		int index;
		int w = image[0].getWidth();
		int h = image[0].getHeight();

		int[] maskenKopie = null;
		int[] kopie = image[0].getRGB(0, 0, w, h, null, 0, w);
		if(image.length > 1 && image[1] != null){
			maskenKopie = image[1].getRGB(0, 0, w, h, null, 0, w);
		}

		int breite = Integer.valueOf(wert);
		breite = breite - (breite % 2);
		int[] pixels = new int[breite * breite];
		int[] maskenPixels = new int[breite * breite];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j ++) {
				index = i * w + j; 

				for (int k = breite / -2; k < breite / 2; k++) {
					for (int l = breite / -2; l < breite / 2; l++) {
						if( index + k * w + l > 0 && index + k * w + l < kopie.length){
							pixels[(k + breite / 2) * breite + (l + breite / 2)] = kopie[ index + (k * w + l) ];
							if(maskenKopie != null){
								maskenPixels[(k + breite / 2) * breite + (l + breite / 2)] = maskenKopie[ index + (k * w + l) ];
							}
						}
					}
				}

				kopie[index] = calculate( pixels, maskenPixels, index, breite);
			}
		}

		image[0].setRGB(0, 0, w, h, kopie, 0, w);
		return image[0];
	}



	protected abstract int calculate(int[] pixel, int[] maskenPixel, int index, int breite);
}