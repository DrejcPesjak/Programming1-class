import java.util.Scanner;

public class IzpisStevk {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        long stevilo = sc.nextLong();
                
        while (stevilo > 0) {
			int stevka = (int) (stevilo%10);
            System.out.println(stevka); 
			stevilo = stevilo / 10L;                       
        }        
    }
}