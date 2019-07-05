import java.util.Scanner;

public class DN03_63180224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ml = sc.nextInt();  //meseci v letu
        int dm = sc.nextInt();  //dni v mesecu
        int dt = sc.nextInt();  //dni v tednu
        int f = sc.nextInt();   //dela prost dan
        int p = sc.nextInt();   //praznik

        int mZac = sc.nextInt();
        int lZac = sc.nextInt();
        int mKon = sc.nextInt();
        int lKon = sc.nextInt();

        //   * dela prost dan in praznik
        //   + praznik
        //   x dela prost
        //   _ nič

        int mesecniZamik = dm % dt;
        int zacetniZamik = ( mesecniZamik*(lZac-1)*ml + mesecniZamik*(mZac-1) ) % dt;

        int stevecPozicija = zacetniZamik+1;
        int mesecVletu = mZac;
        int zaporedniDan = ((lZac-1)*ml*dm + (mZac-1)*dm) + 1;


        for(int trenutnoLeto = lZac; trenutnoLeto <= lKon; trenutnoLeto++) {

            if(trenutnoLeto == lKon)
                ml = mKon;

            do {
                System.out.println(mesecVletu + "/" + trenutnoLeto);

                //zamik v mesecu
                for(int i = 1; i < stevecPozicija; i++) {
                    System.out.print("     ");
                }

                for(int danVmesecu = 1; danVmesecu <= dm; danVmesecu++, zaporedniDan++) {
                    System.out.printf("%4d", danVmesecu);


                    if(zaporedniDan % p == 0 && stevecPozicija % f == 0)
                        System.out.print('*');
                    else if(zaporedniDan % p == 0)
                        System.out.print('+');
                    else if(stevecPozicija % f == 0)
                        System.out.print('x');
                    else
                        System.out.print('_');


                    if(stevecPozicija >= dt) {
                        stevecPozicija = 1;
                        System.out.println();
                    } else {
                        stevecPozicija++;
                    }
                }

                //nova vrstica za konec meseca
                if(stevecPozicija!=1)
                    System.out.println();

                mesecVletu++;
            } while(mesecVletu <= ml);

            mesecVletu = 1;
        }
    }
}
