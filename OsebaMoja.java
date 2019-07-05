public class Oseba {
	
	//podatki
	private String ime, priimek;
	private char spol;
	private int letoRojstva;
	private Oseba oce, mati;
	private static int stUstvarjenih;
	
	//konstruktorji
	public Oseba(String ime, String priimek, char spol, int letoRojstva) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;
		stUstvarjenih++;
	}
	public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;
		this.oce = oce;
		this.mati = mati;
		stUstvarjenih++;
	}
	
	//metode
	public int starost(int leto) {
		return leto - this.letoRojstva;
	}
	public boolean jeStarejsaOd(Oseba os) { 
		if (this.vrniLetoRojstva() < os.vrniLetoRojstva())
			return true;
		else 
			return false;
	} 
		//-----------------------------------------
	public String imeOceta() {
		if(oce == null)
			return "null";
		else
			return this.oce.vrniIme();
	}
	public boolean jeBratAliSestraOd(Oseba os) {
		if(this.vrniOce() == os.vrniOce() && this.vrniMati() == os.vrniMati() && this != os) {
			return true;
		}
		else
			return false;
	}
	public boolean jeSestraOd(Oseba os) {
		if(this.jeBratAliSestraOd(os) && this.spol == 'Z')
			return true;
		else 
			return false;
	}
	public boolean jeTetaOd(Oseba os) {
		if(this.jeSestraOd(os.vrniOce()) || this.jeSestraOd(os.vrniMati())) 
			return true;
		else
			return false;
	}
	public boolean jeOcetovskiPrednikOd(Oseba os) {
		// ????
		return false;
	}
	public static int steviloUstvarjenih() {
		return stUstvarjenih;
	}
	
	
	//getter, setter
	public Oseba vrniOce() { return this.oce; }
	public Oseba vrniMati() { return this.mati; } 
	//public char vrniSpol() { return this.spol; }
	public int vrniLetoRojstva() { return letoRojstva; } 
	public String vrniIme() { return this.ime; }
	public void nastaviIme(String novoIme) { this.ime = novoIme; }
	public String toString() { return  ime + " " + priimek + " (" + spol + "), " + letoRojstva; }

}