import java.util.Scanner;

public class SteviloStevk {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int stevilo = sc.nextInt();
		int stStevk = 0;
		
		while(stevilo>0) {
			stevilo /= 10;
			stStevk++;
		}
		System.out.println(stStevk);
		
        
		/*int stevec = 1000000000;
		do{
			int celiDel = stevilo/stevec;
		} while(celiDel == 0);*/
    }
}