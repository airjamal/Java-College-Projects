import java.awt.image.BufferedImage;

public class PixelgraphicFilter extends Areafilter implements Filter {

	public BufferedImage process(String value, BufferedImage ... eingabe){
		
		int index;
		int w = eingabe[0].getWidth();
		int h = eingabe[0].getHeight();

		int[] maskenKopie = null;
		int[] kopie = eingabe[0].getRGB(0, 0, w, h, null, 0, w);
		if(eingabe.length > 1 && eingabe[1] != null){
			maskenKopie = eingabe[1].getRGB(0, 0, w, h, null, 0, w);
		}

		int breite = Integer.valueOf(value);
		breite = breite - (breite % 2);
		int[] pixels = new int[breite * breite];
		int[] maskePixel = new int[breite * breite];
		
		int temp;
		for (int i = breite; i < (h - breite); i += breite) {
			for (int j = breite; j < (w - breite); j += breite) {

				index = i * w + j; 

				for (int k = breite / -2; k < breite / 2; k++) {
					for (int l = breite / -2; l < breite / 2; l++) {
						if( index + k * w + l > 0 && index + k * w + l < kopie.length){
							pixels[(k + breite / 2) * breite + (l + breite / 2)] = kopie[ index + (k * w + l) ];
							if(eingabe.length > 1 && eingabe[1] != null){
								maskePixel[(k + breite / 2) * breite + (l + breite / 2)] = maskenKopie[ index + (k * w + l) ];
							}
						}
					}
				}

				temp = calculate( pixels, maskePixel, index, breite);

				for (int k = breite / -2; k < breite / 2; k++) {
					for (int l = breite / -2; l < breite / 2; l++) {
						if(maskenKopie != null){
							if(maskenKopie[ index + (k * w + l) ] > 0xFF000000){
								kopie[ index + (k * w + l) ] = temp;
							}
						}else{
							kopie[ index + (k * w + l) ] = temp;
						}
							
					}
				}
			}
		}

		eingabe[0].setRGB(0, 0, w, h, kopie, 0, w);
		return eingabe[0];
	}


	protected int calculate(int[] pixels, int[] maskenPixel, int index, int breite) {
		int aktPixel = 0;
		
		int rotGesamt = 0;
		int blauGesamt = 0;
		int gruenGesamt = 0;
		
		for(int pixel : pixels){
			if(pixel != 0){
				rotGesamt +=   (pixel >> 16) & 0xff;
				gruenGesamt += (pixel >> 8) & 0xff;
				blauGesamt +=  (pixel >> 0) & 0xff;
			}
		}
		
		aktPixel= (rotGesamt/ pixels.length <<16) | (gruenGesamt/ pixels.length << 8) | (blauGesamt/ pixels.length<< 0) | 0;
		
		return aktPixel;
	}

}
