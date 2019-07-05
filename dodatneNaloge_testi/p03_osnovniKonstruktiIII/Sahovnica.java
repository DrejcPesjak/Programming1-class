import java.util.Scanner;

public class Sahovnica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int visina = sc.nextInt();
		int sirina = sc.nextInt();
		int stranicaA = sc.nextInt();


		System.out.print('+');
		printPartLine(sirina*stranicaA, '-');
		System.out.println(" +");

		for(int v = 0; v<visina*stranicaA; v++) {
			System.out.print('|');
			
			if((v/stranicaA)%2 == 0) {
				printWholeLine(sirina, stranicaA, 0);
			} else {
				printWholeLine(sirina, stranicaA, 1);
			}

			System.out.println(" |");
		}

		System.out.print('+');
		printPartLine(sirina*stranicaA, '-');
		System.out.println(" +");
		
	}

	private static void printWholeLine(int sir, int a, int bool) {
		for(int z = 0; z<sir; z++) {
			if(z%2==bool)
				printPartLine(a, ' ');
			else
				printPartLine(a, '*');
		}
	}

	private static void printPartLine(int n, char c) {
		for(int j = 0; j<n; j++) 
			System.out.printf(" %c", c);
	}

	//private static void printLinija()
}