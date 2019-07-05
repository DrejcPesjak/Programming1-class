/**
 * Razred Oseba - tabela objektov brez ...
 */

public class Oseba {

	// private static final int MAX_ST_PRIJATELJEV = 100;

	private String ip;
	private int starost;
	private PostniNaslov postniNaslov;
	private Oseba[] prijatelji;
	// private int stPrijateljev;

    /**
     * Ustvari nov objekt razreda Oseba.
     */
	 
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        this.ip = ip;
		this.starost = starost;
		this.postniNaslov = postniNaslov;
		
		// this.prijatelji = new Oseba[MAX_ST_PRIJATELJEV];
		// this.stPrijateljev = 0;
		this.prijatelji = null;
    }

    /**
     * Vrne ime in priimek osebe 'this'.
     */
	 
    public String vrniIP() {
        // popravite / dopolnite ...
        return this.ip;
    }

    /**
     * Vrne niz z osnovnimi podatki o osebi 'this'.
     */
	 
    public String toString() {
        // popravite / dopolnite ...
        return String.format("%s (%d), %s",ip,starost,postniNaslov.toString());
    }

    /**
     * Vrne stevilo prijateljev osebe 'this'.
     */
	 
    public int steviloPrijateljev() {
		// popravite / dopolnite ...
		if (this.prijatelji == null)
			return 0;
		
		int stPrijateljev = 0;
		for (int i = 0; i < prijatelji.length; i++) {
			if (this.jePrijateljOd(prijatelji[i])) {
				stPrijateljev++;
			}
		}
        return stPrijateljev;
    }

    /**
     * Vrne 'true' natanko v primeru, ce je oseba 'this' prijatelj osebe 'os'.
     */
	 
    public boolean jePrijateljOd(Oseba os) {
        // popravite / dopolnite ...
		if(os.prijatelji == null || os.prijatelji.length == 0) {
			return false;
		}
		for (int i = 0; i < os.prijatelji.length; i++) {
			if (os.prijatelji[i] == this) {
				return true;
			}
		}
        return false;
    }

	private static Oseba[] increase(Oseba[] osebe) {
		int newSize = (osebe == null) ? 1 : osebe.length + 1;
		Oseba[] copy = new Oseba[newSize];
		for (int i = 0; i < copy.length - 1; i++)
			copy[i] = osebe[i];
		return copy;
	}
	
	private void dodajPrijatelja(Oseba os) {
		// this.prijatelji[this.stPrijateljev++] = os;
		this.prijatelji = Oseba.increase(this.prijatelji);
		this.prijatelji[this.prijatelji.length - 1] = os;
	}
	
    /**
     * Ce sta osebi 'prva' in 'druga' razlicni in ce se nista prijatelja, to
     * postaneta, sicer pa se ne zgodi nic.
     */
	 
    public static boolean vzpostaviPrijateljstvo(Oseba prva, Oseba druga) {
        // popravite / dopolnite ...
		if (prva == druga || 
			prva.jePrijateljOd(druga) ||
			druga.jePrijateljOd(prva)) {
			return false;
		}
		prva.dodajPrijatelja(druga);
		druga.dodajPrijatelja(prva);
        return true;
    }

    /**
     * Vrne 'true' natanko v primeru, ce oseba 'os' prebiva na istem postnem
     * naslovu kot oseba 'this'.
     */
	 
    public boolean naIstemNaslovuKot(Oseba os) {
        // popravite / dopolnite ...
        return this.postniNaslov.jeEnakKot(os.postniNaslov);
    }

    /**
     * Vrne stevilo prijateljev osebe 'this', ki zivijo na istem postnem
     * naslovu kot oseba 'this'.
     */
	 
    public int steviloPrijateljevNaIstemNaslovu() {
        // popravite / dopolnite ...
        if (this.prijatelji == null)
			return 0;
		int stevilo = 0;
		for (int i = 0; i < this.prijatelji.length; i++) {
			if (this.prijatelji[i].naIstemNaslovuKot(this))
				stevilo++;
		}
		return stevilo;
    }

    /**
     * Vrne najstarejsega prijatelja osebe 'this' (prvega, ce jih je vec;
     * null, ce jih ni).
     */
	 
    public Oseba najstarejsiPrijatelj() {
        // popravite / dopolnite ...
		if (this.prijatelji == null)
			return null;
		int iNaj = 0;
		for (int i = 1; i < this.prijatelji.length; i++) {
			if (this.prijatelji[i].starost > this.prijatelji[iNaj].starost) {
				iNaj = i;
			}
		}
        return this.prijatelji[iNaj];
    }
}
