import java.util.Scanner;

public class Izstevanka {

	/**
	 * Vrne indeks otroka, ki izpade.
	 * @param stOtrok stevilo (preostalih) stOtrok
	 * @param stBesed stevilo besed izstevanke
	 */

	private static int kdoIzpade(int stOtrok, int stBesed) {
		return (stBesed - 1) % stOtrok;
	}
	
	/**
	 * Izloci element z indeksom 'ix' iz tabele 't' tako, da 
	 * element tabele desno od indeksa 'ix' pomakne za eno mesto v levo.
	 * @param d efektivna dolzina tabele (do kod se nam splaca premikati).
	 */
	
	private static void izloci(String[] t, int ix, int d) {
		for (int i = ix; i < d - 1; i++) {
			t[i] = t[i + 1];
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stOtrok = sc.nextInt();
        int stBesed = sc.nextInt();

        // preberi imena otrok
		
        String[] otroci = new String[stOtrok];
        for (int i = 0;  i < stOtrok;  i++) {
            otroci[i] = sc.next();
        }
		
		// stevilo krogov izstevanke
		int stKrogov = stOtrok - 1;
		
		// stevilo otrok, ki so se v igri
		int stOtrokVIgri = stOtrok;
		
		// simuliraj izstevanko
		for (int krog = 0; krog < stKrogov; krog++) {
			// ugotovi, kdo izpade
			int ixIzpadlega = kdoIzpade(stOtrokVIgri, stBesed);
			System.out.println(otroci[ixIzpadlega]);
			
			// izloci izpadlega
			izloci(otroci, ixIzpadlega, stOtrokVIgri);
			stOtrokVIgri--;
		}
    }
}
