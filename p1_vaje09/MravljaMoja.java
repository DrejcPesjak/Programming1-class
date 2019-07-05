import java.util.Scanner;

public class Mravlja {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int visina = sc.nextInt();
        int sirina = sc.nextInt();
        
		int n = visina-1 + sirina-1;
		int r = visina>sirina ? sirina-1:visina-1;
		
        System.out.println(faktoriela(n)/
							( faktoriela(r)*faktoriela(n-r) ));
    }
    
    private static int faktoriela(int n) {
        if(n == 1) {
            return 1;
        } else {
            return n * faktoriela(n-1);
        }
    }
}