import java.util.Scanner;
import java.util.Arrays;

public class Dolgovi {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] nepobotani = new int[n][n];
		
		for(int i = 0; i < k; i++) {
			int siJeIzposodil = sc.nextInt();
			int posojevalec = sc.nextInt();
			int enotaDenarja = sc.nextInt();
			
			nepobotani[siJeIzposodil-1][posojevalec-1] += enotaDenarja;			
		}
		
		System.out.println(Arrays.deepToString(nepobotani));
        System.out.println(Arrays.deepToString(urediDolgove(nepobotani)));
    }
	
	private static int[][] urediDolgove(int[][] nepobotani) {
		//pozor spreminjanje te "nove" tabele nepobotani, v bistvu spreminja originalno
		//ker v resnici to samo hrani kazalec na originalno
		
		for(int i = 0; i < nepobotani[0].length; i++) {
			for(int j = i+1; j < nepobotani[0].length; j++) {
				
				if(nepobotani[i][j] > nepobotani[j][i]) {
					nepobotani[i][j] -= nepobotani[j][i];
					nepobotani[j][i] = 0;
				}
				else if (nepobotani[i][j] < nepobotani[j][i]){
					nepobotani[j][i] -= nepobotani[i][j];
					nepobotani[i][j] = 0;
				}
				else {
					nepobotani[i][j] = 0;
					nepobotani[j][i] = 0;
				}
					
				
			}
		}
		
		return nepobotani;
	}
}