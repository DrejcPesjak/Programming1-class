import java.util.Scanner;

public class DN05_63180224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

		int zadnIndeks = -1;
		//dva pomeni; prva cifra za maxVisino in druga za D
		int[][] tabelaMax = new int[n][2];
		long sumD = 1;

		int prejsni = sc.nextInt();	int trenutniD = 1;
		//System.out.print(trenutniD + " ");

		for(int stVisin = 1; stVisin<n; stVisin++) {
			int trenutni = sc.nextInt();

			if(trenutni >= prejsni) {
				trenutniD++;				

				//preglej vse prejsnje maximume
				for(int i = zadnIndeks; i>=0; i--) {
					if(trenutni >= tabelaMax[i][0]) {

						if(i==0)
							trenutniD = stVisin+1;
						else
							trenutniD += tabelaMax[i][1];

						tabelaMax[i][0] = tabelaMax[i][1] = 0; //briši manjši maximum
						zadnIndeks--;
					} else 
						break;			
				}			
					
			} else {
				//dodamo prejsnega ki je maximum
				tabelaMax[zadnIndeks+1][0] = prejsni;
				tabelaMax[zadnIndeks+1][1] = trenutniD; 
				zadnIndeks++;
				trenutniD = 1;
			}
			
			sumD += trenutniD;
			//System.out.print(trenutniD + " ");
			prejsni = trenutni;
		}

		System.out.println(sumD);
	}
}