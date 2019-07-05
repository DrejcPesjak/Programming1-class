import java.util.Scanner;

public class RomanjeI {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		int p = sc.nextInt();
		
		while(d > 0) {
			System.out.println(d);
			d -= p;
		}
	}
}