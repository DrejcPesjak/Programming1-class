import java.util.Scanner;

public class Collatz {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int stevilo = sc.nextInt();
        int stevec = 1;
		
        while(stevilo > 1) {
			if(stevilo%2==0)
				stevilo /= 2;
			else
				stevilo = stevilo*3+1;
			
			stevec++;
		} 
		
		System.out.println(stevec);
    }
}