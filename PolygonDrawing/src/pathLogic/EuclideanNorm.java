package pathLogic;

public class EuclideanNorm {
	
	public static double euclideanNorm(double[] p1, double[] p2) {
		
		
		double x1 = p1[0];
		double x2 = p2[0];
		double y1 = p1[1];
		double y2 = p2[1];
		
		return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
		
	}
	
	public static void printVector(double[] input) {
		
		for(double x : input) {
			
			System.out.println(x);
			
		}
		
		
	}
	
	

}
