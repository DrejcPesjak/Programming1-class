import java.util.Scanner;

class Metode4 {

  public static double vrednostDepozita(double glavnica, double obrMera) {
    double novoStanje = glavnica + glavnica*obrMera/100;
    return novoStanje;
  }  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    for(int i=1; i<=3; i++) {
      double g = sc.nextDouble();
      double om = sc.nextDouble();
      // double ns = vrednostDepozita(g,om);
      // System.out.println(ns);
      System.out.println(vrednostDepozita(g,om));
    }
  }
}