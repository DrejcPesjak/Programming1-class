//63180224
// V prejsnji vrstici navedite svojo vpisno stevilko.
import java.util.Arrays;

public class Naloga {

    public static class Predmet {
        private int sifra;
        private String naziv;
        private int kt;
        private int tip;
        private Modul modul;
        private Izvajalec[] izvajalci;

        public Predmet(int sifra, String naziv, int kt, int tip, Modul modul, Izvajalec[] izvajalci) {
            this.sifra = sifra;
            this.naziv = naziv;
            this.kt = kt;
            this.tip = tip;
            this.modul = modul;
            this.izvajalci = izvajalci;
        }

        public int vrniKT() {
            return kt;
        }
        public int vrniTIP() {
            return tip;
        }
        public Izvajalec[] vrniIzvajalce() {
            return izvajalci;
        }
        public int vrniSifra() {
            return sifra;
        }
        public Modul vrniModul() {
            return modul;
        }
        public String vrniNaziv() {
            return naziv;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Modul {
        private int sifra;
        private String naziv;

        public Modul(int sifra, String naziv) {
            this.sifra = sifra;
            this.naziv = naziv;
        }

        public int vrniSifro() {
            return sifra;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Izvajalec {
        private int sifra;
        private String ip;

        public Izvajalec(int sifra, String ip) {
            this.sifra = sifra;
            this.ip = ip;
        }

        public int vrniSifri() {
            return sifra;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.ip);
        }
    }

    public static class Predmetnik {
        private Predmet[] predmeti;

        public Predmetnik(Predmet[] predmeti) {
            this.predmeti = predmeti;
        }

        public int steviloKT() {
            int summa = 0;
            for(Predmet element : predmeti) {
                summa += element.vrniKT();
            }
            return summa;
        }

        public int[] tipiPredmetov() {
            int[] tipi = new int[3];

            for(Predmet element : predmeti) {
                if(element.vrniTIP() == 0){
                    tipi[0]++;
                } else if (element.vrniTIP() == 1) {
                    tipi[1]++;
                } else if (element.vrniTIP() == 2) {
                    tipi[2]++;
                }
            }

            return tipi;
        }

        public Predmet predmetZNajvecIzvajalci() {
            int maxSt = 0;
            Predmet maxPredmet = null;

            for(int i = 0; i<predmeti.length; i++) {
                int novoSt = predmeti[i].vrniIzvajalce().length;

                if(novoSt > maxSt) {
                    maxSt = novoSt;
                    maxPredmet = predmeti[i];
                } else if (novoSt == maxSt && maxPredmet.vrniSifra() > predmeti[i].vrniSifra()) {
                    maxPredmet = predmeti[i];
                }
            }

            return maxPredmet;
        }

        public int predmetiModula(int sifra, String[] nazivi) {

            for(int i = 0, j = 0; i<predmeti.length; i++) {

                if(predmeti[i].vrniModul() != null) {
                    if(predmeti[i].vrniModul().vrniSifro() == sifra) {
                        nazivi[j] = predmeti[i].vrniNaziv();
                        j++;
                    }
                }

                if(i >= predmeti.length-1)
                    return j;
            }

            return -1;
        }

        public int steviloIzvajalcev() {

            Izvajalec[] izvajalci = new Izvajalec[0];

            for(Predmet trenutni : predmeti) {
                Izvajalec[] trenutniIzvaSeznam = trenutni.vrniIzvajalce();
                for(Izvajalec trenutniIzva : trenutniIzvaSeznam ) {

                    boolean jeNotri = false;
                    for(int i = 0; i<izvajalci.length; i++) {
                        if(trenutniIzva == izvajalci[i]) {
                            jeNotri = true;
                            break;
                        }
                    }

                    //ce ni notri povecaj tabelo in ga dodaj
                    if(!jeNotri) {
                        int dolzina = izvajalci.length;
                        izvajalci = Arrays.copyOf(izvajalci, dolzina+1);
                        izvajalci[dolzina] = trenutniIzva;
                    }

                }

            }

            return izvajalci.length;
        }

        public int steviloEnakoMocnihModulov(Predmetnik drugi) {
            int[][] razModuli = new int[this.predmeti.length][2];

            for(int i = 0, j = 0; i<predmeti.length; i++) {
                if(predmeti[i].vrniModul() != null) {
                    int sifraMod = predmeti[i].vrniModul().vrniSifro();

                    for(int z = 0; z<predmeti.length; z++) {
                        if(razModuli[z][0]==sifraMod) {
                            razModuli[z][1]++;
                            break;
                        } else if(z==j) {
                            razModuli[z][0] = sifraMod;
                            razModuli[z][1] = 1;
                            j++; break;
                        }
                    }
                }
            }

            for(int i = 0; i<drugi.predmeti.length; i++) {
                if(drugi.predmeti[i].vrniModul() != null) {
                    int sifraMod = drugi.predmeti[i].vrniModul().vrniSifro();

                    for(int z = 0; z<predmeti.length; z++) {
                        if(razModuli[z][0]==sifraMod) {
                            razModuli[z][1]--;
                            break;
                        }
                    }
                }
            }

            int st = 0;
            for(int i = 0; i<predmeti.length; i++) {
                if(razModuli[i][0] != 0 && razModuli[i][1] == 0) {
                    st++;
                }
            }

            return st;
        }
    }
}
