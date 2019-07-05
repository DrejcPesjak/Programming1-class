import java.util.Scanner;

public class VrstaZbor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stVojakov = sc.nextInt();

        // preberi višine vojakov
        int[] visine = new int[stVojakov];
        for (int i = 0;  i < stVojakov;  i++) {
            visine[i] = sc.nextInt();
        }
		
		
		boolean vsajEnPravPostavljen = false;
		for(int i=0; i <= visine.length-1; i++) {
			if(lokalnoPrav(i,visine)) {
				System.out.println(i);
				vsajEnPravPostavljen = true;
			}
		}
		
		if(!vsajEnPravPostavljen) {
			System.out.println("NOBEDEN");
		}
		
		/*boolean[] indeksNarobe = new boolean[stVojakov];
		boolean vsiPravPostavljeni = true;
		for (int i=0; i <= visine.length; i++) {
			boolean pravPostavljen1 = false;
			boolean pravPostavljen2 = false;
			
			if(visine[i-1] != null) {
				if(visine[i-1] <= visine[i]) {
					pravPostavljen1 == true;
				}
			}
			if(visine[i+1] != null) {
				if(visine[i+1] >= visine[i]) {
					pravPostavljen2 == true;
				}
			}
			
			
			if(!pravPostavljen1 || !pravPostavljen2) {
				indeksNarobe[i] = true;
				vsiPravPostavljeni = false;
			}		
		}
		
		if(vsiPravPostavljeni)
			System.out.println("NOBEDEN");*/
		
		

    }
	
	private static boolean lokalnoPrav(int indeks, int[] tabelca) {
		/*boolean obstajaManjsi = false;
		for(int i=0; i < indeks; i++) {
			if(tabelca[i] <= tabelca[indeks])
				obstajaManjsi = true;
		}
		
		boolean obstajaVecji = false;
		for(int i = tabelca.length-1; i > indeks; i--) {
			if(tabelca[indeks] <= tabelca[i])
				obstajaVecji = true;
		}
		
		return (obstajaManjsi && obstajaVecji);*/
		
		return ((indeks==0 || tabelca[indeks-1]<=tabelca[indeks]) && 
				(indeks == tabelca.length-1 || tabelca[indeks]<=tabelca[indeks+1]));
		
	}
}
