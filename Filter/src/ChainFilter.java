import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ChainFilter implements Filter {
	
	private int current, total;
	
	private ArrayList<Filter> filters = new ArrayList<Filter>();
	
	private ArrayList<String> values = new ArrayList<String>();
	
	public BufferedImage process(String wert, BufferedImage ... image) {
		
		total = filters.size();
		
		current = 0;
		
		for (Filter filter : filters) {
			image[0] = filter.process(wert, image);
			current++;
		}
		current = total;
		return image[0];
		
	}
	
	



	public void add(Filter filter, String wert){
		this.filters.add( filter );
		this.values.add( wert );
	}

}
