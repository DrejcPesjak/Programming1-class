import java.util.Scanner;

public class Piramida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int st_vrstic = sc.nextInt();

        for(int i = 1; i <= st_vrstic; i++) {
            for(int presdledki = st_vrstic-i; presdledki>0; presdledki--) {
                System.out.print(' ');
            }

            for(int zvezdice = i*2-1; zvezdice>0; zvezdice--) {
                System.out.print('*');
            }

            System.out.println();
        }
    }
}
