public class Oseba {
	
	// atributi razreda
	private String ime;
	private String priimek;
	private char spol;
	private int letoRojstva;
	
	private Oseba oce, mati;
	
	// stevec ustvarjenih oseb
	private static int stUstvarjenih = 0;
	
	/** Ustvari osebo s podanim imenom, priimekom, spolom in letom rojstva */
	
	public Oseba(String ime, String priimek, char spol, int letoRojstva) {
		/*this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;*/
		this(ime, priimek, spol, letoRojstva, null, null);
	}
	
	/** Ustvari osebo s podanim imenom, priimekom, spolom in letom rojstva, ocetom in materjo */
	
	public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;
		this.oce = oce;
		this.mati = mati;
		// stUstvarjenih++; ali 
		Oseba.stUstvarjenih++;
	}	
	
	// setter in getter metode
	public String vrniIme() {
		return this.ime;
	}
	
	public void nastaviIme(String novoIme) {
		this.ime = novoIme;
	}
	
	public String toString() {
		return String.format("%s %s (%c), %d", 
						this.ime, this.priimek, this.spol, this.letoRojstva);
	}
	
	public int starost(int leto) {
		return leto - this.letoRojstva;
	}
	
	public boolean jeStarejsaOd(Oseba os) {
		return this.letoRojstva < os.letoRojstva;
	}
	
	/** Vrne ime oceta osebe 'this' oz. null, ce oce ni znan */
	
	public String imeOceta() {
		if (this.oce == null)
			return null;
		return this.oce.ime;
	}
	 
	/** 
	 * Vrne 'true' natanko v primeru, ce je oseba 'this' brat ali sestra 
	 * osebe 'os'.
	 */

	public boolean jeBratAliSestraOd(Oseba os) {
		return (this.oce != null && this.mati != null && this.oce == os.oce && 
				this.mati == os.mati && this != os);
	}

	/** 
	 * Vrne 'true' natanko v primeru, ce je oseba 'this' sestra osebe 'os'. 
	 */

	public boolean jeSestraOd(Oseba os) {
		return (this.spol == 'Z' && this.jeBratAliSestraOd(os));
	}	
	
	/** 
	 * Vrne 'true' natanko v primeru, ce je oseba 'this' teta osebe 'os'. 
	 */

	public boolean jeTetaOd(Oseba os) {
		return (os.oce != null && this.jeSestraOd(os.oce) || 
				os.mati != null && this.jeSestraOd(os.mati));
	}
	 
	/** 
	 * Vrne 'true' natanko v primeru, ce je oseba 'this' ocetovski 
	 * prednik osebe 'os'. 
	 */

	public boolean jeOcetovskiPrednikOd(Oseba os) {
		Oseba p = os.oce;
		while (p != null && p != this) {
			p = p.oce;
		}
		return (p == this);
	}

	/** Vrne stevilo doslej ustvarjenih oseb. */
	
	public static int steviloUstvarjenih() {
		return stUstvarjenih;
		// return Oseba.stUstvarjenih;
	}
	
}