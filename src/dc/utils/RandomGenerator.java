package dc.utils;

public abstract class RandomGenerator {
	
	private RandomGenerator() {
		super();
	}
	
	public static Integer randomInteger(Integer min,Integer max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	public static Double randomDouble(Double min,Double max) {
		return min + (Math.random() * ((max - min) + 1));
	}
}