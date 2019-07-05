import java.util.ArrayList;
import java.util.List;
/**
 * NALOGA 2
 */

public class Recept {    // kuharski recept

    private Korak[] koraki;    // koraki recepta

    public Recept(Korak[] koraki) {
        this.koraki = koraki;
    }

    public Korak[] vrniKorake() {
        return this.koraki;
    }

    /**
     * Naloga (a) -- vrne trajanje recepta v minutah.
     */
    public int trajanje() {
		int sumT = 0;
		for(Korak k : koraki) {
			sumT += k.vrniTrajanje();
		}        
        return sumT;
    }

    /**
     * Naloga (b) -- vrne indeks prvega koraka s podano akcijo (-1, "ce te
     * akcije ni).
     */
    public int prviKorakZAkcijo(String akcija) {
		for(int i = 0; i<koraki.length; i++) {
			if(koraki[i].vrniAkcijo().equals(akcija)) {
				return i;
			}
		}

        return -1;
    }

    /**
     * Naloga (d) -- vrne "stevilo snovi, ki se pojavljajo SAMO na vhodih v
     * korake recepta.
     */
    public int steviloVstopnihSnovi() {
		//naredi tabelo za vse vhode, in vse izhode
		//nato povecaj stevec za vsak vhod ki NI med izhodi        

		int stVhodov = 0;

		List<Snov> vhode = new ArrayList<Snov>();
		List<Snov> izhode = new ArrayList<Snov>();

		for(Korak k : koraki) {
			Snov[] snoviK = k.vrniVhode();		
			for(Snov s : snoviK){
				vhode.add(s);
			}

			snoviK = k.vrniIzhode();
			for(Snov s : snoviK){
				izhode.add(s);
			}
		}


		for(Snov s1 : vhode) {
			boolean niIzhod = true;

			for(Snov s2: izhode) {
				if(s1==s2) {
					niIzhod = false;
				}
			}

			if(niIzhod)
				stVhodov++;
		}
		
        return stVhodov;
    }
}
