import java.util.Scanner;

class Metode3 {

  public static void vrednostDepozita(double glavnica, double obrMera) {
    double novoStanje = glavnica + glavnica*obrMera/100;
    System.out.println(novoStanje);
  }  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    for(int i=1; i<=3; i++) {
      double g = sc.nextDouble();
      double om = sc.nextDouble();
      vrednostDepozita(g,om);
    }
  }
}