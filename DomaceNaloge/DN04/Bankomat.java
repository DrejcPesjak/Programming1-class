//63180224

public class Bankomat {
    //stevilo bankovcev po 5,2 in 1 dinar
    private int bankovec5, bankovec2, bankovec1;
    private int[] maxDvig = {0,0};
    private Datum[] maxDatum  = {new Datum(1,1,1901), new Datum(2,1,1901)};
    private int maxEnDvig;

    public Bankomat() {
        bankovec5 = bankovec2 = bankovec1 = 0;
        maxEnDvig = 0;
    }

    //getter,setter
    public int vrniN5() {
        return this.bankovec5;
    }

    public int vrniN2() {
        return this.bankovec2;
    }

    public int vrniN1() {
        return this.bankovec1;
    }

    //metode
    public void nalozi(int k5, int k2, int k1) {
        this.bankovec5 += k5;
        this.bankovec2 += k2;
        this.bankovec1 += k1;
    }

    public void izpisi() {
        System.out.println(this.vrniN5() + " | " + this.vrniN2() + " | " + this.vrniN1());
    }

    public int kolicinaDenarja() {
        return (this.vrniN5()*5 + this.vrniN2()*2 + this.vrniN1()*1);
    }

    public boolean dvigni(int dvig, Datum datum) {
        for(int i = bankovec5; i>=0; i--) {
            for(int j = bankovec2; j>=0; j--) {
                for(int z = bankovec1; z>=0; z--) {
                    if(jeTocno(i,j,z,dvig)) {
                        bankovec5 -= i;
                        bankovec2 -= j;
                        bankovec1 -= z;

                        if(this.maxEnDvig < dvig) {
                            this.maxEnDvig = dvig;
                        }

                        if(maxDatum[1].jeEnakKot(datum)) {
                            maxDvig[1] += dvig;
                        } else {
                            if(maxDvig[0] < maxDvig[1]) {
                                maxDvig[0] = maxDvig[1];
                                maxDatum[0] = maxDatum[1];
                            }
                            maxDvig[1] = dvig;
                            maxDatum[1] = datum;
                        }

                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean jeTocno(int k5, int k2, int k1, int dvig) {
        return (k5*5 + k2*2 + k1 == dvig);
    }

    public int najDvig() {
        return maxEnDvig;
    }

    public Datum najDatum() {
        if(maxDvig[0] == 0 && maxDvig[1] == 0)
            return null;
        else
            return (maxDvig[0] >= maxDvig[1] ? maxDatum[0]:maxDatum[1]);
    }

}
