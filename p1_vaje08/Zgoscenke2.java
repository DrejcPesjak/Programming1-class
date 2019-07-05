import java.util.Scanner;
import java.util.Arrays;

public class Zgoscenke2 {

	/** Vrne indeks najmanjsega elementa v tabeli. */
	
	private static int indeksMinimuma(int[] t) {
		int ixMin = 0;
		for (int i = 1; i < t.length; i++) {
			if (t[i] < t[ixMin]) {
				ixMin = i;
			}
		}
		return ixMin;
	}

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stZgoscenk = sc.nextInt();
		int kapacitetaZgoscenke = sc.nextInt();
		
		int[] zasedenosti = new int[stZgoscenk];
		
		while (sc.hasNextInt())	{
			// Preberi velikost datoteke
			int velikostDatoteke = sc.nextInt();
			
			// Poisci ideks najmanj izkoriscene zgoscenke
			int ixZgoscenke = indeksMinimuma(zasedenosti);
			
			// Ali lahko datoteko spravimo na zeljeno zgoscenko?
			if(velikostDatoteke +zasedenosti[ixZgoscenke] > kapacitetaZgoscenke) {
				break;
			}
			// Povecaj zasedenosti izbrane zgoscenke
			zasedenosti[ixZgoscenke] +=velikostDatoteke;
			System.out.printf("%d EP -> zgoscenka %d %s%n",velikostDatoteke,ixZgoscenke+1,Arrays.toString(zasedenosti));
		}
		
    }
}
