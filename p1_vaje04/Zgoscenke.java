import java.util.Scanner;

public class Zgoscenke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stZgoscenk = sc.nextInt();
        int kapacitetaZgoscenke = sc.nextInt();

        int stevilkaZgoscenke = 1;
        int zasedenostZgoscenke = 0;

        while(sc.hasNextInt() && stevilkaZgoscenke <= stZgoscenk) {
            int velikostDatoteke = sc.nextInt();
            if(zasedenostZgoscenke + velikostDatoteke <= kapacitetaZgoscenke) {
                zasedenostZgoscenke += velikostDatoteke;
            } else {
                stevilkaZgoscenke++;
                zasedenostZgoscenke = 0 + velikostDatoteke;
            }

            if(stevilkaZgoscenke<=stZgoscenk) {
                System.out.printf("%d EP -> zgoscenka %d (%d EP)%n",
                                    velikostDatoteke,
                                    stevilkaZgoscenke,
                                    zasedenostZgoscenke);
            }
        }
    }
}
