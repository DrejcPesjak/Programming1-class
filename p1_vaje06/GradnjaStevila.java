import java.util.Scanner;
import java.lang.Math;

public class GradnjaStevila {
	
	private static int steviloStevk(int n) {
		int stevec = 0;
		while(n>0){
			n /= 10;
			stevec++;
		}
		
		return stevec;
	}
	
	private static int potencaCelihStevil(int st, int potenca) {
		int potencirana = st;
		while(potenca > 1) {
			potencirana *= st;
			potenca--;
		}
		
		return potencirana;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n,d;
		
		switch(a) {
			case 1: 
				n = sc.nextInt();
				d = sc.nextInt();
				
				System.out.println(n*10 + d);
				break;
				
			case -1:
				n = sc.nextInt();
				System.out.println(n/10);
				break;
				
			case 2:
				n = sc.nextInt();
				d = sc.nextInt();
								
				System.out.println((d * potencaCelihStevil(10, steviloStevk(n))) + n);
				break;
				
			case -2:
				n = sc.nextInt();
				
				System.out.println((n % potencaCelihStevil(10, steviloStevk(n)-1)));
				break;
		}
	}
}