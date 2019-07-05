import java.util.Scanner;

class Primer2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();
    if (a+b>c && a+c>b && b+c>a) {
      double s = (a+b+c)/2;
      double p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
      System.out.println(p);
    }
    else {
      System.out.println("Napacni podatki");
    }
  }
}