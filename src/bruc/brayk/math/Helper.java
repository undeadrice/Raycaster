package bruc.brayk.math;

public class Helper {

	public static double calcAngle(double cameraAngle, double dAngle) {
		double angle = cameraAngle + dAngle;
		if (angle > 360) {
			angle -= 360;
			return angle;
		} else if (angle < 0) {
			angle += 360;
			return angle;
		}

		return angle;
	}

	public static double calcAngle(double angle) {
		if (angle > 360) {
			angle -= 360;
			return angle;
		} else if (angle < 0) {
			angle += 360;
			return angle;
		}

		return angle;
	}

	public static double pythagoreanC(Vector start, Vector x, Vector y) {
		double a = Math.abs(start.getX() - x.getX());
		double b = Math.abs(start.getY() - y.getY());

		double c = Math.sqrt(a * a + b * b);

		return 2.0;
	}

	public static double pythagoreanC(Vector start, Vector x, double b) {
		double a = Math.abs(start.getY() - x.getY());
		double c = Math.sqrt(a * a + b * b);

		return 2.0;
	}

	public static double pythagoreanC(Vector start, double a, Vector y) {
		double b = Math.abs(start.getX() - y.getX());
		double c = Math.sqrt(a * a + b * b);

		return 2.0;
	}
	
	public static double pythagoreanC(Vector a, Vector b) {
		double x = b.getX()-a.getX();
		double y = b.getY() - a.getY();
		
		
		return Math.sqrt(x*x + y*y);
		
	}

}
