import java.util.Scanner;

public class DN01_63180224 {

    private static void horizontala(int n, int theta, int lambda, int stPeriode, char znakPrvi, char znakVmesni, char znakDrugi) {
        int stevec = 0;
        int lambda2 = lambda/2 - 1;
        boolean majhenTheta = false;
        if(stPeriode==0) {
            //začetek vrstice
            stevec = theta;
            if(theta > lambda2) {
                stevec++;
            }
        } else if (stPeriode==n) {
            //konec vrstice
            lambda = theta;
            if(theta > lambda2) {
                lambda++;
            }
        }


        while(stevec < lambda2 && stevec < lambda) {
            System.out.print(znakPrvi);
            stevec++;
            majhenTheta = true;
            if(stevec == lambda2)
                stevec += 2; //zakaj mam tuki 2 in ne 1
        }

        if(majhenTheta && stevec != lambda)
            System.out.print(znakVmesni);

        while(stevec < lambda){
            System.out.print(znakDrugi);
            stevec++;
        }
        if(stPeriode!=n)
            System.out.print(znakVmesni);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int lambda = sc.nextInt();
        int A = sc.nextInt();
        int theta = sc.nextInt();

        //prva vrstica minusi s plusi in presledki
        for(int i = 0; i<=n; i++) {
            horizontala(n, theta, lambda, i, '-', '+', ' ');
        }
        System.out.println();

        //stene Vala
        for(int i = 1; i<A; i++) {
            for(int j = 0; j<=n; j++) {
                horizontala(n, theta, lambda, j, ' ', '|', ' ');
            }
            System.out.println();
        }

        //zadnja vrstica
        for(int i = 0; i<=n; i++) {
            horizontala(n, theta, lambda, i, ' ', '+', '-');
        }
        System.out.println();
    }
}
