
public class MultiThresholdFilter extends Pixelfilter implements Filter  {

	
	protected int calculate(int aktPixel, String wert) {
		int r,g,b,durchschnitt;
		String[] werte = wert.split("_");
		
		if(wert.equals("") || wert.equals("multitreshold")){
			werte = new String[3];
			werte[0] = "64";
			werte[1] = "128";
			werte[2] = "128";
		}		
		
		r = (aktPixel >> 16) & 0xff;
		g = (aktPixel >> 8) & 0xff;
		b = (aktPixel >> 0) & 0xff;

		int neuerPixel = 0xFF000000;

		durchschnitt = (r + g + b) / 3;
		
		for(int i = werte.length - 1; i >= 0; i--){ 
			if(durchschnitt > Integer.valueOf(werte[werte.length - 1])){
				durchschnitt = 255;
			}else if(durchschnitt < Integer.valueOf(werte[0])){
				durchschnitt = 0;
			}else if(durchschnitt <= Integer.valueOf(werte[i]) && i != 0 && durchschnitt > Integer.valueOf(werte[i - 1])){
				durchschnitt = Integer.valueOf(werte[i - 1]);
			}
		}
		
		neuerPixel |= durchschnitt << 16;
		neuerPixel |= durchschnitt << 8;
		neuerPixel |= durchschnitt;			

		return neuerPixel;
	}

}
