import java.util.Scanner;

public class DN05_63180224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] visine = new int[n];
        int dist = 0;

        for(int i = 0; i<visine.length; i++) {
            visine[i] = sc.nextInt();
        }

        //iteracija cez vse visine in pristevanje k D
        for(int i = 0; i<visine.length; i++) {

            //predlgedovanje tistih pred njim
            int di=0;
            for(int z = i-1; z>=0; z--) {
                if (visine[z] > visine[i]) {
                    di = i-z;
                    break;
                }
            }

            dist += (di>0 ? di : i+1);
        }

        System.out.println(dist);
    }
}
