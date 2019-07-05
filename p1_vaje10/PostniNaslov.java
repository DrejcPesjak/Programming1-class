public class PostniNaslov {

	// ulica s hisno stevilko
    private String ulicaHS;  
    private int postnaStevilka;
    private String posta;

    /**
     * Ustvari nov objekt razreda PostniNaslov.
     */
	 
    public PostniNaslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    /** 
     * Vrne predstavitev postnega naslova 'this' v obliki niza.
     */
	 
    public String toString() {
        // popravite / dopolnite ...
        
		return String.format("%s, %d %s", this.ulicaHS, this.postnaStevilka, this.posta);
    }

    /** 
     * Vrne 'true' natanko v primeru, ce objekt 'pn' predstavlja isti postni
     * naslov kot objekt 'this'.
     */
	 
    public boolean jeEnakKot(PostniNaslov pn) {
        // popravite / dopolnite ...
        
		return (this.ulicaHS.equals(pn.ulicaHS) &&
				this.postnaStevilka == pn.postnaStevilka &&
				this.posta.equals(pn.posta));
    }
}
