import java.util.Scanner;

public class Izstevanka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stOtrok = sc.nextInt();
        int stBesed = sc.nextInt();

        // preberi imena otrok
        String[] otroci = new String[stOtrok];
        for (int i = 0;  i < stOtrok;  i++) {
            otroci[i] = sc.next();
        }
		
		
		
		while(otroci.length > 1) {
			int indeksIzpadlega = (stBesed%otroci.length) -1;
			System.out.println(indeksIzpadlega);
			
			//izpiši izpadlega
			System.out.println( otroci[indeksIzpadlega] );
			
			//zbriši izpadlega
			otroci = manjsePolje(indeksIzpadlega, otroci);
		}	
    }
	
	
	private static String[] manjsePolje(int ix, String[] trenutnaTabela) {
		String[] novaTabela = new String[trenutnaTabela.length-1];
		
		for(int i = 0; i<trenutnaTabela.length; i++) {
			if(i<ix) 
				novaTabela[i] = trenutnaTabela[i];
			else if(i>ix)
				novaTabela[i-1] = trenutnaTabela[i];
		}
		
		return novaTabela;
	}
}
