class Metode6a {
  
  public static void main(String[] args) {
    double spMeja=-10;
    double zgMeja=10;
    double korak=0.5;
    // izdelamo tabelo exp(x) za vrednosti x od spMeja do zgMeja s korakom korak
    double x=spMeja;
    while (x<=zgMeja) {
      System.out.printf("%6.1f %15.5f %15.5f%n",x,MatFunkcije.exp(x),Math.exp(x));
      x += korak;
    }
  }
}