import java.util.Scanner;
import java.util.Random;

public class Dvoboj {

	//private static int zmagovalec

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		int seme = sc.nextInt();
		int dobljenePartije = sc.nextInt();
		int verjetnostA = sc.nextInt();
		int verjetnostB = sc.nextInt();
		
		Random generator = new Random(seme);		
		
		int zAna = 0; int zBojan = 0;
		while( zAna<dobljenePartije && zBojan<dobljenePartije) {
			int nak = generator.nextInt(100);
			if(nak < verjetnostA) {
				++zAna;
				System.out.print("A");
			}
			else if(verjetnostA <= nak && nak < verjetnostA+verjetnostB) {
				++zBojan;
				System.out.print("B");
			}
			else 
				System.out.print("-");
		}
		
    }
}
