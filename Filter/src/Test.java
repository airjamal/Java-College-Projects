import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;

public class Test implements Filter{

	public BufferedImage process(String output, BufferedImage ... image) {
		
		BufferedImage maskenImage = null;
		
		if(image.length >= 1){
			maskenImage = image[1];
		}
		try {
		Controller.imageSpeichern(new MonochromeFilter().process("", deepKopie(image[0]), maskenImage), output + "_monochrome.bmp");
		Controller.imageSpeichern(new ThresholdFilter().process("128", deepKopie(image[0]), maskenImage), output + "_threshold_128.bmp");
		Controller.imageSpeichern(new ThresholdFilter().process("192", deepKopie(image[0]), maskenImage), output + "_threshold_192.bmp");
		Controller.imageSpeichern(new MultiThresholdFilter().process("64", deepKopie(image[0]), maskenImage), output + "_multithreshold_64.bmp");
		Controller.imageSpeichern(new MultiThresholdFilter().process("128", deepKopie(image[0]), maskenImage), output + "_multithreshold_128.bmp");
		Controller.imageSpeichern(new MultiThresholdFilter().process("192", deepKopie(image[0]), maskenImage), output + "_multithreshold_192.bmp");
		Controller.imageSpeichern(new BlurFilter().process("3", deepKopie(image[0]), maskenImage), output + "_blur_3.bmp");
		Controller.imageSpeichern(new BlurFilter().process("5", deepKopie(image[0]), maskenImage), output + "_blur_5.bmp");
		Controller.imageSpeichern(new ColorReplacementFilter().process("000000", new ColorReplacementFilter().process("808080", new ColorReplacementFilter().process("FFFFFF", new MultiThresholdFilter().process("64_128", deepKopie(image[0]), maskenImage)))), output + "_colorreplacement.bmp");
		Controller.imageSpeichern(new PixelgraphicFilter().process("20", deepKopie(image[0]), maskenImage), output + "_pixel_20.bmp");
		Controller.imageSpeichern(new PixelgraphicFilter().process("40", deepKopie(image[0]), maskenImage), output + "_pixel_40.bmp");
		Controller.imageSpeichern(new PixelgraphicFilter().process("60", deepKopie(image[0]), maskenImage), output + "_pixel_60.bmp");
		Controller.imageSpeichern(new ExtraFilter().process("", deepKopie(image[0]), maskenImage), output + "_extrafilter.bmp");
		Controller.imageSpeichern(new SmartieFilter().process("5", deepKopie(image[0]), maskenImage), output + "_smartiefilter_5.bmp");
		Controller.imageSpeichern(new SmartieFilter().process("10", deepKopie(image[0]), maskenImage), output + "_smartiefilter_10.bmp");
		Controller.imageSpeichern(new ColorBandFilter().process("ROT", deepKopie(image[0]), maskenImage), output + "_colorBand_RED.bmp");
		Controller.imageSpeichern(new ColorBandFilter().process("GRUEN", deepKopie(image[0]), maskenImage), output+ "_colorBand_GREEN.bmp");
		Controller.imageSpeichern(new ColorBandFilter().process("BLAU", deepKopie(image[0]), maskenImage), output+ "_colorBand_BLUE.bmp");
	
		ChainFilter warhol = new ChainFilter();
		warhol.add(new ColorReplacementFilter(), "000000");
		warhol.add(new ColorReplacementFilter(), "808080");
		warhol.add(new ColorReplacementFilter(), "C0C0C0");
		warhol.add(new ColorReplacementFilter(), "FFFFFF");
		warhol.add(new MultiThresholdFilter(), "");
		
		Controller.imageSpeichern(warhol.process("", deepKopie(image[0]), maskenImage), output + "_warhol.bmp");
		
		
		}
		catch(IOException e){
			System.err.println("ERROR 404");
		}return image[0];
	}
	
	BufferedImage deepKopie(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
}
