
public class BlurFilter extends Areafilter {


	protected int calculate(int[] pixels, int[] maskenPixel, int index, int breite) {
		int aktPixel = 0;
		
		int rotGesamt = 0;
		int gruenGesamt = 0;
		int blauGesamt = 0;
		
		for(int i = 0; i< pixels.length;i++) {
			aktPixel = pixels[i];
			if(pixels[i] != 0 && maskenPixel[i] > 0xFF808080) {
				aktPixel = 0;
				rotGesamt +=   (pixels[i] >> 16) & 0xff;
				gruenGesamt += (pixels[i] >> 8) & 0xff;
				blauGesamt +=  (pixels[i] >> 0) & 0xff;
			}
		}
				
		aktPixel |= rotGesamt / pixels.length << 16;
		aktPixel |= gruenGesamt / pixels.length << 8;
		aktPixel |= blauGesamt / pixels.length;
		
		return aktPixel;
	}
}
