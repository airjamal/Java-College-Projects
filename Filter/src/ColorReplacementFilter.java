import java.awt.image.BufferedImage;

public class ColorReplacementFilter extends Pixelfilter implements Filter {
	

	public BufferedImage process(String wert, BufferedImage ... eingabe){
		if(!wert.contains("_")){
			int rot = (int) (Math.random() * 255);
			int gruen = (int) (Math.random() * 255);
			int blau = (int) (Math.random() * 255);

			int col = 0xFF000000;
			col |= rot << 16;
			col |= gruen << 8;
			col |= blau;
			
			wert += "_" + String.format("%06X", (0xFFFFFF & col));;
		}
		return super.process(wert, eingabe);
	}
	
	protected int calculate(int aktPixel, String wert) {
		
		String[] werte = wert.split("_");
		String compare = String.format("%06X", (0xFFFFFF & aktPixel));

		if(compare.equals(werte[0])){
			aktPixel = Integer.parseInt(werte[1], 16);
		}

		return aktPixel;
	}
}