public class Funkcije {
	
	public static double koren(double x, double epsilon) {
		
		double vsota = 0.0;
		double clen = 1;
		int n = 0;
		while (Math.abs(clen) > epsilon) {
			vsota += clen;
			clen = clen * (1.0 - 2.0 * n) * (x - 1.0) / (2 * (n + 1.0));
			n++;
		}
		return vsota;
	}
	
}