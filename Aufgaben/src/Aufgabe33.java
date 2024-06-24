
public class Aufgabe33 {

	public float energyLevel;
	public float radius; 
	public float height;
	
	public float volume() {
	return (float) (Math.PI*radius*radius*height);
	}
	
	public float energy() {
		return energyLevel * volume();
	}
}
