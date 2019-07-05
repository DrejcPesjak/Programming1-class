class Primer4 {
  public static void main(String[] args) {
    for(int i=1; i<=10; i=i+1) {
      for(int j=1; j<=10; j=j+1) {
        int p = i*j;
        System.out.printf("%4d",p);
      }
      System.out.println();
    }
  }
}