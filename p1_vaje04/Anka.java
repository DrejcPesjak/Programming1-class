import java.util.Scanner;

public class Anka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();
        int stevilo_kombinacij = 0;

        for(int i = 1; i < 10; i += 2) {
            for(int j = m+1; j < 10; j++) {
                for(int z = 0; z < 10; z++) {
                    if(z % d == 0) {
                        System.out.println(i + "-" + j + "-" + z);
                        stevilo_kombinacij++;
                    }
                }
            }
        }
        System.out.println(stevilo_kombinacij);
    }
}
