
public class ThresholdFilter extends Pixelfilter implements Filter {
	int schwellwert;

	protected  int calculate(int aktPixel, String wert){
		int rot,gruen,blau;
		schwellwert = Integer.parseInt(wert);
		
		rot = (aktPixel >> 16) & 0xff;
   		gruen = (aktPixel >> 8) & 0xff;
   		blau = (aktPixel >> 0) & 0xff;
   		
   		int avg = (rot + gruen + blau) / 3;
   		aktPixel = (avg <<16) | (avg << 8) | (avg << 0) | avg;
   		
   		if(avg < schwellwert) {
   			aktPixel = 0xff000000;
   		}
   		else {
   			aktPixel =0xffffffff;
   		}
	
		return aktPixel;
	}
	
}
