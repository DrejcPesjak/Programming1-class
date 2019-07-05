import java.util.Scanner;

public class DN07_63180224{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stPostaj = sc.nextInt();
        int[] casiMedPostajami = new int[stPostaj-1];

        for(int i=0; i<casiMedPostajami.length; i++) {
            casiMedPostajami[i] = sc.nextInt();
        }

        int stPrimerov = sc.nextInt();
        int skupnoCakanje = 0;

        for(int i = 0; i<stPrimerov; i++){
            //read zacetna casa
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            int lev = 0, desn = casiMedPostajami.length-1;
            while( lev <= desn ) {
                if(t1<t2) {
                    t1 += casiMedPostajami[lev];
                    lev++;
                } else {
                    t2 += casiMedPostajami[desn];
                    desn--;
                }
            }

            if(!(lev==0 || desn==casiMedPostajami.length-1))
                skupnoCakanje += t1<t2 ? t2-t1 : t1-t2;
        }

        System.out.println(skupnoCakanje);

    }
}
