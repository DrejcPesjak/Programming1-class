class Metode5 {
  
  public static void main(String[] args) {
    for(int n=1; n<=1000; n++) {
      if (jePopolno(n)) {
        System.out.println(n);
      }
    }
  }
  
  public static boolean jePopolno(int stevilo) {
    int vsota=0;
    for(int delitelj=1; delitelj<=stevilo/2; delitelj++) {
      if (stevilo%delitelj == 0) {
        vsota += delitelj;
      }
    }
    return vsota == stevilo;
    /* if (vsota == stevilo) {
         return true;
       }
       else {
         return false;
       } 
    */
  }
}