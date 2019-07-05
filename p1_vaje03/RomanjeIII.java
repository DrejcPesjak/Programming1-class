import java.util.Scanner;

public class RomanjeIII {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dolzina = sc.nextInt();
		int pot = sc.nextInt();
		int utrujenost = sc.nextInt();
		
		/*for(int dan = 1; dolzina >= pot; dan++) {
			System.out.format("%d. dan: %d -> %d (prehodil %d)%n", dan, dolzina, dolzina - pot, pot);
			dolzina -= pot;
		}*/
		
		int dan = 1;
		do{
			if(dolzina < pot) 
					pot = dolzina;
				
			System.out.printf("%d. dan: %d -> %d (prehodil %d)%n", dan, dolzina, dolzina - pot, pot);
			dolzina -= pot;
			pot -= utrujenost;
			dan++;
		} while((dolzina > 0) && (pot > 0));
	}
}