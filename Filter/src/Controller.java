import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Controller {

	public static void main(String[] args) {

		String filter = "";
		String mask = "";
		String input = "";
		String wert = "";
		String output = "";
		BufferedImage image;
		BufferedImage maskeImage = null;
		ArrayList<String> commands = new ArrayList<String>();
		Map<String, Filter> filters = new HashMap<>();

		filters.put("blur", new BlurFilter());
		filters.put("monochrome", new MonochromeFilter());
		filters.put("colorband", new ColorBandFilter());
		filters.put("threshold", new ThresholdFilter());
		filters.put("multithreshold", new MultiThresholdFilter());
		filters.put("colorreplacement", new ColorReplacementFilter());
		filters.put("pixel", new PixelgraphicFilter());
		filters.put("extra", new ExtraFilter());
		filters.put("smartie", new SmartieFilter());
		filters.put("test", new Test());

		for (int a = 0; a < args.length; a++) {
			if (args[a].equals("-m")) {
				mask = args[a + 1];
			} else if (!args[a].contains(".") && !args[a].contains("-")) {
				commands.add(args[a]);
			} else if (args[a].contains(".") && !args[a - 1].equals("-m")) {
				if (input.equals("")) {
					input = args[a];
				} else {
					output = args[a];
				}
			}
		}

		ChainFilter warhol = new ChainFilter();
		warhol.add(new ColorReplacementFilter(), "000000");
		warhol.add(new ColorReplacementFilter(), "808080");
		warhol.add(new ColorReplacementFilter(), "C0C0C0");
		warhol.add(new ColorReplacementFilter(), "FFFFFF");
		warhol.add(new MultiThresholdFilter(), "");

		filters.put("warhol", warhol);

		try {
			image = imageLaden(input);

			if (!mask.equals("")) {
				maskeImage = imageLaden(mask);
			}
			if (commands.size() == 1) {
//		Einzelner Filter mit evtl. Maske
				String command = commands.get(0);
				filter = command.split("_")[0].toLowerCase();
				wert = command.substring(command.indexOf("_") + 1);
				image = filters.get(filter).process(wert, image, maskeImage);
			} else {
				// Filterkette mit evtl. Maske
				ChainFilter kette = null;
				kette = new ChainFilter();
				for (String command : commands) {
					filter = command.split("_")[0];
					wert = command.substring(command.indexOf("_") + 1);
					kette.add(filters.get(filter), wert);
				}
				image = kette.process("_", image, maskeImage);
			}
			imageSpeichern(image, output);
		} catch (IOException e) {
			System.err.println("Diese Datei konnte nicht gefunden werden :(");
		}
	}

//	Das Image wird mit dieser Methode hervorgerufen
	public static BufferedImage imageLaden(String file) throws IOException {
		BufferedImage laden = null;
		laden = ImageIO.read(new File("bildvorlage/" + file));
		System.out.println("Reading Complete");

		return laden;
	}

//	Das editierte Image wird mit dieser Methode gespeichert
	public static void imageSpeichern(BufferedImage image, String file) throws IOException {
		ImageIO.write(image, "bmp", new File("bildvorlage/output_" + file));
		System.out.println("Writing Complete");

	}
}
