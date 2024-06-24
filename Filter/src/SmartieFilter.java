
public class SmartieFilter extends Areafilter implements Filter {

	protected int calculate(int[] pixels, int[] maskenPixel, int index, int breite) {
		int aktPixel = 0;

		int rotGesamt = 0;
		int gruenGesamt = 0;
		int blauGesamt = 0;
		
		int newRot = 0;
		int newGruen = 0;
		int newBlau = 0;

		for (int i = 0; i < pixels.length; i++) {
			aktPixel = pixels[i];
			if (pixels[i] != 0 && maskenPixel[i] > 0xFF808080) {

				rotGesamt += (pixels[i] >> 16) & 0xff;
				gruenGesamt = (pixels[i] >> 8) & 0xff;
				blauGesamt += (pixels[i] >> 0) & 0xff;

				int hell = (rotGesamt + gruenGesamt + blauGesamt) / 6;
				 newRot = hell;
				 newGruen = hell;
				 newBlau = hell;
					
			}
		}
		
		aktPixel = (24 | (newRot+42) << 15 | (newGruen-3) << 9 | newBlau*newRot/(newGruen+1))<<1;

		return aktPixel;
	}
}
