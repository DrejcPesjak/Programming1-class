
/**
 * NALOGA 3
 *
 * Dopolnite/spremenite SAMO ozna"ceni del razreda!
 */

import java.awt.*;

public class Diagram extends Platno {

    //=========================================================================
    // Notranji razredi
    //=========================================================================

    public static class Skatla {
        private int stRazdelkov;
        private double x, y;

        public Skatla(int stRazdelkov, double x, double y) {
            this.stRazdelkov = stRazdelkov;
            this.x = x;
            this.y = y;
        }

        public int vrniStRazdelkov() {
            return this.stRazdelkov;
        }

        public double vrniX() {
            return this.x;
        }

        public double vrniY() {
            return this.y;
        }

        public String toString() {
            return String.format("[stRazdelkov = %d, x = %.1f, y = %.1f]", this.stRazdelkov, this.x, this.y);
        }
    }

    public static class Povezava {
        private Skatla prva, druga;

        public Povezava(Skatla prva, Skatla druga) {
            this.prva = prva;
            this.druga = druga;
        }

        public Skatla vrniPrvo() {
            return this.prva;
        }

        public Skatla vrniDrugo() {
            return this.druga;
        }
    }

    //=========================================================================
    // Primer
    //=========================================================================

    // POZOR!
    //
    // Uporabljajte atribute, ne konstante (torej this.skatle, ne SKATLE)!

    private static final Skatla[] SKATLE = {
        new Skatla(3, 2.0, 1.0),
        new Skatla(1, 0.0, 7.0),
        new Skatla(2, 7.0, 1.0),
        new Skatla(4, 6.0, 5.0),
    };

    private static final Povezava[] POVEZAVE = {
        new Povezava(SKATLE[0], SKATLE[1]),
        new Povezava(SKATLE[0], SKATLE[2]),
        new Povezava(SKATLE[0], SKATLE[3]),
        new Povezava(SKATLE[2], SKATLE[3]),
    };

    private static final double D_PAPIR = 10.0;
    private static final double W_SKATLA = 2.0;

    //=========================================================================
    // Metoda main
    //=========================================================================

    public static void main(String[] args) {
        Diagram diagram = new Diagram(SKATLE, POVEZAVE, D_PAPIR, W_SKATLA);
        diagram.sproziRisanje(args);
    }

    //=========================================================================
    // Atributi, konstruktor in nestati"cne metode
    //=========================================================================

    private Skatla[] skatle;      // "skatle
    private Povezava[] povezave;  // povezave med "skatlami
    private double dPapir;        // dol"zina stranice lista papirja (v cm)
    private double wSkatla;       // "sirina "skatle (v cm)

    public Diagram(Skatla[] skatle, Povezava[] povezave, double dPapir, double wSkatla) {
        this.skatle = skatle;
        this.povezave = povezave;
        this.dPapir = dPapir;
        this.wSkatla = wSkatla;
    }

    //=========================================================================
    // DOPOLNITE / SPREMENITE!
    //=========================================================================

    // wp: "sirina platna
    // hp: vi"sina platna

    protected void narisi(Graphics2D g, double wp, double hp) {
        g.setColor(Color.RED);
		for(Povezava p : povezave) {
			double[] tocka1 = sredisceSkatle(p.vrniPrvo(), wp, hp);
			double[] tocka2 = sredisceSkatle(p.vrniDrugo(), wp, hp);
			
			g.drawLine(ri(tocka1[0]), ri(tocka1[1]), ri(tocka2[0]), ri(tocka2[1]));
		}

		
		double krajsi = wp<hp ? wp:hp;
		double enKvadrat = krajsi/dPapir;

		for(Skatla s : this.skatle) {
			//narisem celotno rumeno 
			g.setColor(Color.YELLOW);
			int x = ri(enKvadrat*s.vrniX());
			int y = ri(enKvadrat*s.vrniY());
			double visinaSkatle = enKvadrat * s.vrniStRazdelkov();
			g.fillRect(x, y, ri(sirinaSkatle(wp,hp)), ri(visinaSkatle));


			//nato obrobe za vsak razdelek
			g.setColor(Color.BLACK);
			for(int i = 0; i<s.vrniStRazdelkov(); i--) {		
				g.drawRect(x, y+ i*(int)enKvadrat, ri(sirinaSkatle(wp,hp)), ri(enKvadrat));
			}
		}
		
    }

    /**
     * Vrne "sirino "skatle v pikslih.
     */
    public double sirinaSkatle(double wp, double hp) {
        if(wp<hp) {
			return (wp/dPapir)*wSkatla;
		} else {
			return (hp/dPapir)*wSkatla;
		}
    }

    /**
     * Vrne koordinati sredi"s"ca podane "skatle v pikslih.
     */
    public double[] sredisceSkatle(Skatla sk, double wp, double hp) {
        double xSredisce = 0.0;
        double ySredisce = 0.0;

		//enkvadrat=krajsi wp/hp  deljeno dPapir
		//x = enkvadrat*skatla.vrniX + xSkatla/2*enkvadrat 
		//y= enkvadrat*skatla.vrniY + stRazdelkov/2*enkvadrat

		double krajsi = wp<hp ? wp:hp;
		double enKvadrat = krajsi/dPapir;

		xSredisce = enKvadrat*sk.vrniX() + (wSkatla/2.0)*enKvadrat;
		ySredisce = enKvadrat*sk.vrniY() +(sk.vrniStRazdelkov()/2.0)*enKvadrat;

        return new double[]{xSredisce, ySredisce};
    }
}
