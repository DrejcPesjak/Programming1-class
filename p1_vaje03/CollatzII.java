import java.util.Scanner;

public class CollatzII {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
    
        short zacetek = sc.nextShort();
		short konec = sc.nextShort();
        int maxClenov = 0; int najmanjseStevilo = 0; 
		
		while(zacetek <= konec) {
			int stevilo = zacetek;
			
			int steviloClenov = 1;
			for(; stevilo > 1; steviloClenov++) {
				
				if(stevilo%2==0)
					stevilo /= 2;
				else
					stevilo = stevilo*3+1;
				
			} 
			if(maxClenov < steviloClenov) {
				maxClenov = steviloClenov;
				najmanjseStevilo = zacetek;
			}
			zacetek++;
		}
		
				
		System.out.println(najmanjseStevilo);
		System.out.println(maxClenov);
    }
}