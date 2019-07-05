//63180224

public class Datum {
    private int dan, mesec, leto;

    public Datum(int dan, int mesec, int leto) {
        this.dan = dan;
        this.mesec = mesec;
        this.leto = leto;
    }

    public int vrniDan() {
        return this.dan;
    }

    public int vrniMesec() {
        return this.mesec;
    }

    public int vrniLeto() {
        return this.leto;
    }

    public String toString() {
        return String.format("%02d.%02d.%04d", dan, mesec,leto);
    }

    public boolean jeEnakKot(Datum datum) {
        return (this.vrniDan() == datum.vrniDan() &&
                this.vrniMesec() == datum.vrniMesec() &&
                this.vrniLeto() == datum.vrniLeto() );
    }
}
