import java.util.Scanner;

public class Smreka {

	/**
	 * Izpise <n> zaporednih znakov <znak> v vrstici. 
	 */
	 
	private static void znaki(int length, char znak) {
		for (int j = 0; j < length; j++) {
			System.out.print(znak);
		}	
	}

    /*
     * Narise piramido visine <visina>, zamaknjeno za <zamik> 
     * presledkov v desno.
     */
	 
    private static void piramida(int visina, int zamik) {
		int stPresledkov = visina - 1;
		int stZvezdic = 1;
		
		for (int i = 0; i < visina; i++) {
			//zamiki
			znaki(zamik, ' ');
			// presledki
			znaki(stPresledkov, ' ');
			// zvezdice
			znaki(stZvezdic, '*');
			System.out.println();
			
			stZvezdic += 2;
			stPresledkov--;
		}	
    }
	
	/**
	 * Izrise smreko z <n> vejami.
	 */
	
	private static void smreka(int n) {
		for (int i = 1; i <= n; i++){
			piramida(i, (n-i));
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int visina = sc.nextInt();
		smreka(visina);
    }	
}
