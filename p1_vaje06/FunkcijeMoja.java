public class Funkcije {
	public static double koren(double x, double epsilon) {
		double vsota = 0;
		double clen = 0;
		int n = 0;
		
		do {
			clen = potenca(-1, n) * faktoriela(2*n) /
					( (1-2*n)*potenca(faktoriela(n),2)*potenca(4,n) ) *
					potenca(x-1, n);
			vsota += clen;
			n++;
		} while(clen > epsilon);
		
		return vsota;
	}
	
	private static int faktoriela(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * faktoriela(n-1);
		}
	}
	
	private static double potenca(double st, int potenca) {
		double potencirana = st;
		while(potenca > 1) {
			potencirana *= st;
			potenca--;
		}
		
		return potencirana;
	}
}