import java.util.Scanner;

public class Smreka {

    /*
     * Nariše piramido visine <visina>, zamaknjeno za <zamik> 
     * presledkov v desno.
     */
    
	
    private static void piramida(int visina, int zamik) {
		
		for(int i = 0; i < visina; i++) {
			for(int z = zamik; z>0; z--) {
				System.out.print(" ");
			}		
			for(int j = 0; j < visina-i-1; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
    }
	
	private static void smreka(int n) {
		for(int i = 1; i<=n; i++) {
			piramida(i, n-i);				
		}
	}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		smreka(sc.nextInt());
    }   
}
