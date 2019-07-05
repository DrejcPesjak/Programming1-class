import java.util.Scanner;

public class CollatzII {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int spMeja = sc.nextInt();
        int zgMeja = sc.nextInt();
        
        int najClen = 0;
        int najStClenov = 0;
        for (int zacetek = spMeja; zacetek = zgMeja; zacetek++) {
            
             izracunamo dolzino Collatzovega zaporedja, ki ga tvori
             stevilo zacetek
            
            int clen = zacetek;
            int stClenov = 1;
            while (clen  1) {
                if (clen % 2 == 0) {
                     stevilo clen je sodo
                    clen = 2;
                } else {
                     ... potem je liho, itak
                    clen = 3  clen + 1;
                }
                stClenov++;
            }
            
            if (stClenov  najStClenov) {
                najStClenov = stClenov;
                najClen = zacetek;
            }
        }
        System.out.println(najClen);
        System.out.println(najStClenov);
    }
}