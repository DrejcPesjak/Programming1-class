
/**
 * NALOGA 1
 */

public class Park {

    /**
     * Naloga (a) -- vrne "stevilo prostih parkirnih mest na parkiri"s"cu.
     */
    public static int steviloProstih(boolean[][] p) {
		int stevec = 0;        
		
		for(boolean[] row : p) {
			for(boolean spot : row) {
				if(spot)
					stevec++;
			}
		}
        return stevec;
    }

    /**
     * Naloga (b) -- preveri, ali obstaja vrstica z vsaj k zaporednimi (!)
     * prostimi mesti.
     */
    public static boolean zaporedje(boolean[][] p, int k) {
        boolean drzi = false;        
		
		for(boolean[] row : p) {
			int stevec = 0;

			for(boolean spot : row) {
				if(spot)
					stevec++;
				else
					stevec=0;
			}

			if(stevec >= k){
				drzi = true;
				break;
			}
		}
        
        return drzi;
    }

    /**
     * Naloga (c) -- vrne "stevilo VSEH parkirnih mest v gara"zni hi"si.
     */
    public static int steviloMest(boolean[][][] g) {
        return g.length*g[0].length*g[0][0].length;
    }

    /**
     * Naloga (d) -- vrne indeks nadstropja z najve"c prostimi mesti.
     */
    public static int najboljProstoNadstropje(boolean[][][] g) {
		int maxIx = 0; int maxStProstih = 0;       
		for(int i = 0; i<g.length; i++) {
			int stProstih = steviloProstih(g[i]);
			
			if(stProstih > maxStProstih) {
				maxIx = i;
				maxStProstih = stProstih;
			}
		
		}
        return maxIx;
    }
}
