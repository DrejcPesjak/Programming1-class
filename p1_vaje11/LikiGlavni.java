import java.util.Scanner;

public class LikiGlavni {

    /** 
	 * Izpise podatke o vseh likih. 
	 */
	 
    private static void izpisiPodatke(Lik[] liki) {
        // for (int i = 0; i < liki.length; i++) {
		// 	System.out.println(liki[i].toString());
		// }
		for (Lik lik : liki) {
			System.out.println(lik);
		}
    }

    /** 
	 * Vrne lik z najvecjo ploscino v podani tabeli. 
	 */
	 
    private static Lik likZNajvecjoPloscino(Lik[] liki) {
        int najPloscina = 0;
		int iNaj = 0;
		for (int i = 0; i < liki.length; i++) {
			int ploscina = liki[i].ploscina();
			if (ploscina > najPloscina) {
				najPloscina = ploscina;
				iNaj = i;
			}
		}
        return liki[iNaj];
    }

    /** 
	 * Izpise podatke o vseh pravokotnikih in kvadratih v podani tabeli. 
	 */
	 
    private static void pravokotnikiInKvadrati(Lik[] liki) {
        for (int i = 0; i < liki.length; i++) {
			if (liki[i] instanceof Pravokotnik) {
				// alternativa: klic liki[i].vrsta.equals(...)
				System.out.println(liki[i]);
			}
		}
    }
	
    /** 
	 * Prebere podatke o vseh likih z vhoda in vrne tabelo s prebranimi
     * podatki. 
	 */
	 
    private static Lik[] preberiLike(Scanner sc) {
        int stLikov = sc.nextInt();

        Lik[] liki = new Lik[stLikov];
        for (int i = 0;  i < liki.length;  i++) {
            int vrsta = sc.nextInt();
            switch (vrsta) {
                case 1:
                    liki[i] = new Pravokotnik(sc.nextInt(), sc.nextInt());
                    break;

                case 2:
                    liki[i] = new Kvadrat(sc.nextInt());
                    break;

                case 3:
                    liki[i] = new Krog(sc.nextInt());
                    break;
            }
        }
        return liki;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lik[] liki = preberiLike(sc);

        int ukaz = sc.nextInt();
        switch (ukaz) {
            case 1:
                izpisiPodatke(liki);
                break;
            case 2:
                Lik najLik = likZNajvecjoPloscino(liki);
                System.out.println(najLik.toString());
                break;
            case 3:
                pravokotnikiInKvadrati(liki);
                break;
        }
    }
}
