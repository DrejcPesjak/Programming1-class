import java.util.Scanner;
import java.util.Arrays;

public class Gauss_elemination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		int width = sc.nextInt();


		double[][] matrix = new double[height][width];
		readMatrix(matrix, sc);


		//indexes
		for(int i = 0; i<matrix.length; i++) {


			//normalize row one
			for(int j = matrix[0].length-1; j>=0; j--) {
				matrix[i][j] /= matrix[i][i];
			}

			//making zeros
			//while not zero
			for(int z = i+1; z<matrix.length; z++) {
				double multiplier = -(matrix[z][i]/matrix[i][i]);				
				for(int y = i; y<matrix[0].length; y++)				
					matrix[z][y] += multiplier*matrix[i][y];
			}

		}


		System.out.println(Arrays.deepToString(matrix));


	}


	/*/**
	* Matrix multiplication : Gij*matrixOne
	* Adds a factor of one row to another.
	*
	public static void Gij(double[][] matrixOne){

	}*/


	public static void readMatrix(double[][] matrixOne, Scanner scan){
		for(int i = 0; i<matrixOne.length; i++){
			for(int j = 0; j<matrixOne[0].length; j++) {
				matrixOne[i][j] = scan.nextDouble();
			}
		}
	}

}