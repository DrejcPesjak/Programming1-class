import java.util.Scanner;

public class Plesalci {

	public static int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		int stMoskih = sc.nextInt();
		int stZensk = sc.nextInt();
		int g = sc.nextInt();
		
		/*int stevec = 1;
		for(int i = 1; i <= stMoskih; i++) {
			for(int j = 1; j <= stZensk; j++) {
				if( gcd(i,j) == g) {
					System.out.println("[" + stevec + "] " + i + " + " + j);
					stevec++;
				}				
			}
		}*/
		
		int stevec = 1;
		for(int i = g; i <= stMoskih; i += g) {
			for(int j = g; j <= stZensk; j += g) {
				if( gcd(i,j) == g ) {
					System.out.println("[" + stevec + "] " + i + " + " + j);
					stevec++;
				}
			}
		}
		
    }
}