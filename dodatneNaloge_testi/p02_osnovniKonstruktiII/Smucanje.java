import java.util.Scanner;

public class Smucanje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int minIx = 0; int minCas = 99999;
		boolean vsiDiskvalificirani = true; 


		for(int j = 0; j < n; j++) {
			int prviCas = sc.nextInt();

			if(prviCas != 0) {
				int drugiCas = sc.nextInt();

				int skupniCas = prviCas + drugiCas;
				if(skupniCas < minCas && drugiCas != 0){
					vsiDiskvalificirani = false;
					minCas = skupniCas; minIx = j+1;				
				}

			}
		}


		if(vsiDiskvalificirani) 
			System.out.println("NIHCE");
		else {
			System.out.println(minIx);
			System.out.println(minCas);		
		}

	
	}
}