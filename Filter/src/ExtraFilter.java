
public class ExtraFilter extends Pixelfilter implements Filter {
	
    public ExtraFilter() {

    }
    @Override
   protected int calculate(int aktPixel, String wert) {
    	
        int rot = (0x00ff0000 & aktPixel) >> 16;
        int gruen = (0x0000ff00 & aktPixel) >> 8;
        int blau = (0x000000ff & aktPixel);
        int hell = (rot+gruen+blau) /6;
        int newRot = hell;
        int newGruen = hell;
        int newBlau = hell;
        
        return (24 | (newRot+42) << 15 | (newGruen-3) << 9 | newBlau*newRot/(newGruen+1))<<1;        
        
        }
}
