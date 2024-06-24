
public class MonochromeFilter extends Pixelfilter implements Filter {
	
	protected  int calculate(int pixelColor, String wert ){
		int rot,gruen,blau;
		
		rot = (pixelColor >> 16) & 0xff;
   		gruen = (pixelColor >> 8) & 0xff;
   		blau = (pixelColor >> 0) & 0xff;
   		
   		int durchschnitt = (rot + gruen + blau) / 3;
   		
   		pixelColor = (durchschnitt <<16) | (durchschnitt << 8) | (durchschnitt << 0) | durchschnitt;
		
		return pixelColor;
	}
	
}
