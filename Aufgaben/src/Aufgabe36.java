
public class Aufgabe36 {

	public static float energyLevel;
	public float radius; 
	public float height;
	
	public float volume() {
	return (float) (Math.PI*radius*radius*height);
	}
	
	public float energy() {
		return energyLevel * volume();
	}
}
