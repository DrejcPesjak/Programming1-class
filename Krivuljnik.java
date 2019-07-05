
import java.awt.*;

public class Krivuljnik extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        Krivulja krivulja = new Srcnica(0.25);
        Krivuljnik krivuljnik = new Krivuljnik(krivulja);
        krivuljnik.sproziRisanje(args, "Krivulje");
    }

    private Krivulja krivulja;

    public Krivuljnik(Krivulja krivulja) {
        this.krivulja = krivulja;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
        //narisi obrobo koordinatnega sistema
		g.setColor(Color.BLACK);
		if(wp>hp) {
			double zacX = wp/2.0 - hp/2.0;
			double zacY = 0; 
			g.drawRect(ri(zacX), ri(zacY), ri(hp), ri(hp));
		} else {
			//polovica širšega - polovica krajšega
			double zacX = 0;
			double zacY = hp/2.0 - wp/2.0;
			g.drawRect(ri(zacX), ri(zacY), ri(wp), ri(wp));
		}
		
		
		//narisi koordinatni sistem
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(ri(xMatVZaslon(0.0, wp, hp)), ri(yMatVZaslon(1.0, wp, hp)), ri(xMatVZaslon(0.0, wp, hp)), ri(yMatVZaslon(-1.0, wp, hp)));
		g.drawLine(ri(xMatVZaslon(-1.0, wp, hp)), ri(yMatVZaslon(0.0, wp, hp)), ri(xMatVZaslon(1.0, wp, hp)), ri(yMatVZaslon(0.0, wp, hp)));
		
		
		//narisi krivuljo
		g.setColor(Color.BLUE);
		for(double kot =  this.krivulja.zacetnaVrednost() ; kot<this.krivulja.koncnaVrednost(); kot += this.krivulja.korak()) {
			double x1 = this.krivulja.koordinataX(kot);
			double y1 = this.krivulja.koordinataY(kot);
			
			//if(kot+this.krivulja.korak()!=)
			double x2 = this.krivulja.koordinataX(kot+this.krivulja.korak());
			double y2 = this.krivulja.koordinataY(kot+this.krivulja.korak());
			
			
			g.drawLine(ri(xMatVZaslon(x1, wp, hp)), ri(yMatVZaslon(y1, wp, hp)), ri(xMatVZaslon(x2, wp, hp)), ri(yMatVZaslon(y2, wp, hp)));
			
		}
		
		
		
		
    }

    /**
     * Vrne koordinato x v koordinatnem sistemu platna, ki ustreza podani
     * koordinati x v koordinatnem sistemu krivulje.
     * @param mx koordinata x v koordinatnem sistemu krivulje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    public static double xMatVZaslon(double mx, double wp, double hp) {
        double novX = 0;
		if(wp>hp) {
			novX = wp/2.0 + (hp/2.0)*mx;
		} else {
			novX = wp/2.0 + (wp/2.0)*mx;
		}
        return novX;
    }

    /**
     * Vrne koordinato y v koordinatnem sistemu platna, ki ustreza podani
     * koordinati y v koordinatnem sistemu krivulje.
     * @param my koordinata y v koordinatnem sistemu krivulje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    public static double yMatVZaslon(double my, double wp, double hp) {
        double novY = 0;
		if(wp>hp) {
			novY = hp/2.0 - (hp/2.0)*my;
		} else {
			novY = hp/2.0 - (wp/2.0)*my;
		}
        return novY;
    }
}
