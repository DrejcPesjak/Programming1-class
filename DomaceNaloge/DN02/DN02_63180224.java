import java.util.Scanner;

public class DN02_63180224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int predzadnjeSt, zadnjeSt;

		switch (x) {
			case 1:
				int prvoSteviloZaporedja = sc.nextInt();
				System.out.println(prvoSteviloZaporedja);
				break;

			case 2:
				//if sc.hasNextInt()
				zadnjeSt = sc.nextInt();

				while(sc.hasNextInt()) {
					zadnjeSt = sc.nextInt();
				}
				System.out.println(zadnjeSt);
				break;

			case 3:
				//podoben kot 2, samo da hranim 2 števili namesto ene zadnje
				predzadnjeSt = sc.nextInt();
				zadnjeSt = sc.nextInt();

				while(sc.hasNextInt()) {
					predzadnjeSt = zadnjeSt;
					zadnjeSt = sc.nextInt();
				}
				System.out.println(predzadnjeSt + zadnjeSt);
				break;

			case 4:
				zadnjeSt = sc.nextInt();
				int stevec = 1;

				while(sc.hasNextInt()) {
					int novoSt = sc.nextInt();

					if(zadnjeSt <= novoSt) {
						stevec++;
					} else 
						break;
					zadnjeSt = novoSt;
				}
				System.out.println(stevec);
				break;

			case 5:
				//dokler narašča povečuješ števec, nato ga shraniš v stevecMAX
				int zadnje = sc.nextInt();
				int stevecMAX, stevec2;
				stevecMAX = stevec2 = 1;

				while(sc.hasNextInt()) {
				    int novo = sc.nextInt();

				    if(zadnje < novo) {
				        stevec2++;
				    } else if (zadnje > novo) {
				        stevec2 = 1;
				    }

					if(stevec2 > stevecMAX)
				    	stevecMAX = stevec2;

				    zadnje = novo;
				}

				System.out.println(stevecMAX);
				break;
		}
	}
}
