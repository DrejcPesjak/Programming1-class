import java.util.Scanner;

class Primer5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vsota = 0;
    while (sc.hasNextInt()) {
      int stevilo = sc.nextInt();
      vsota = vsota + stevilo;
    }
    System.out.println(vsota);
  }
}