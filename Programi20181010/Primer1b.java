class Primer1b {
  
  public static void main(String[] args) {
    double a,b,c,s,p;
    a = BranjePodatkov.preberiDouble();
    b = BranjePodatkov.preberiDouble();
    c = BranjePodatkov.preberiDouble();
    s = (a+b+c)/2;
    p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
    System.out.println(p);
  }
}