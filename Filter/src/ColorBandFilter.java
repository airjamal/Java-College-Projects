
public class ColorBandFilter extends Pixelfilter implements Filter {	
	
	protected enum ColorBandEnum {ROT, GRUEN, BLAU};
		
	protected ColorBandFilter() {
	}
	
	protected int calculate(int pixelFarbe, String eingabe) {
		
		int rotGesamt;
		int gruenGesamt;
		int blauGesamt;
		
		switch (ColorBandEnum.valueOf(eingabe)) {
		case ROT:
			rotGesamt = (pixelFarbe >> 16) & 0xff;
     		gruenGesamt = (pixelFarbe >> 8) & 0xff;
     		blauGesamt = (pixelFarbe >> 0) & 0xff;	
     		pixelFarbe = (rotGesamt <<16) | (0 << 8) | (0 << 0) | 0;
			break;
		case GRUEN:
			rotGesamt = (pixelFarbe >> 16) & 0xff;
     		gruenGesamt = (pixelFarbe >> 8) & 0xff;
     		blauGesamt = (pixelFarbe >> 0) & 0xff;	
     		pixelFarbe = (0 <<16) | (gruenGesamt << 8) | (0 << 0) | 0;
			break;
		case BLAU:
			rotGesamt = (pixelFarbe >> 16) & 0xff;
     		gruenGesamt = (pixelFarbe >> 8) & 0xff;
     		blauGesamt = (pixelFarbe >> 0) & 0xff;	
     		pixelFarbe = (0 <<16) | (0 << 8) | (blauGesamt << 0) | 0;
			break;
		default:
			break;
		}
		
		return pixelFarbe;
	}
}
