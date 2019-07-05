import java.util.Scanner;

public class VozniRed {
	public static void main(String[] args) {
		//preberi pet cifer
		Scanner lojze = new Scanner(System.in);

		int zacUra = lojze.nextInt();
		int zacMin = lojze.nextInt();
		int konUra = lojze.nextInt();
		int konMin = lojze.nextInt();
		
		int minInterval = lojze.nextInt();

		int koncniCas = konUra*60 + konMin;
		for(int zacetniCas = zacUra*60 + zacMin; 
				zacetniCas <= koncniCas; 	zacetniCas += minInterval) {

			System.out.printf("%02d:%02d%n", zacetniCas/60, zacetniCas%60);
		}


	}
}