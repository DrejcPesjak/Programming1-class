import java.util.Scanner;

public class DN06_63180224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();   //visina
        int n = sc.nextInt();   //sirina

        int[][] obmocje = new int[m][n];

        int stDrzav = 0; int stCelicMorja = 0;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                obmocje[i][j] = sc.nextInt();

                if(stDrzav < obmocje[i][j])
                    stDrzav = obmocje[i][j];
                if(obmocje[i][j] == 0)
                    stCelicMorja++;
            }
        }

        switch(sc.nextInt()){
            case 1:
                System.out.println(stDrzav);
                break;

            case 2:
                System.out.println(stCelicMorja);
                break;

            case 3:
                int[] stKopnih = new int[stDrzav];
                for(int i = 0; i<m; i++) {
                    for(int j = 0; j<n; j++) {
                        //trenutna celica =  obmocje[i][j]
                        if(obmocje[i][j]!=0) {
                            if(i==0 || i==m-1 || j==0 || j==n-1)
                                stKopnih[ obmocje[i][j] - 1 ] += 1;
                            else if(obmocje[i-1][j]==0 || obmocje[i+1][j]==0 || obmocje[i][j-1]==0 || obmocje[i][j+1]==0)
                                stKopnih[ obmocje[i][j] - 1 ] += 1;
                        }
                    }
                }

                for(int st : stKopnih)
                    System.out.println( st );
                break;

            case 4:
                int[] tabelaSSosedi = new int[stDrzav];

                for(int prva = 1; prva <= stDrzav; prva++) {
                    for(int druga = prva+1; druga <= stDrzav; druga++) {
                        if(staSosedi(prva,druga,obmocje)){
                            tabelaSSosedi[prva-1]++;
                            tabelaSSosedi[druga-1]++;
                        }
                    }
                }
                int indx = getMaxIx(tabelaSSosedi);
                System.out.println(indx+1);
                System.out.println(tabelaSSosedi[indx]);
                break;

        }
    }

    private static int getMaxIx(int[] tabela) {
        int max = 0; int maxIx = 0;
        for(int j = 0; j<tabela.length; j++){
            if(tabela[j]>max) {
                max = tabela[j];
                maxIx = j;
            }
        }
        return maxIx;
    }

    private static boolean staSosedi(int prva, int druga, int[][] obmocje) {
    	for(int i = 0; i<obmocje.length; i++) {
    		for(int j = 0; j<obmocje[1].length; j++) {

                if(i>0){
                    if(obmocje[i][j] == prva && obmocje[i-1][j]==druga ||
                        obmocje[i][j] == druga && obmocje[i-1][j]==prva )
                        return true;
                }
                if(i<obmocje.length-1){
                    if(obmocje[i][j] == prva && obmocje[i+1][j]==druga ||
                        obmocje[i][j] == druga && obmocje[i+1][j]==prva )
                        return true;
                }

                if(j>0){
                    if(obmocje[i][j] == prva && obmocje[i][j-1]==druga ||
                        obmocje[i][j] == druga && obmocje[i][j-1]==prva )
                        return true;
                }
                if(j<obmocje[1].length-1){
                    if(obmocje[i][j] == prva && obmocje[i][j+1]==druga ||
                        obmocje[i][j] == druga && obmocje[i][j+1]==prva )
                        return true;
                }

                /*if(obmocje[i][j] == prva) {
    				if(obmocje[i-1][j]==druga ||
    					obmocje[i+1][j]==druga ||
    					obmocje[i][j-1]==druga ||
    					obmocje[i][j+1]==druga ) {

    					return true;

    				}
    			}

    			else if(obmocje[i][j] == druga) {
    				if(obmocje[i-1][j]==prva ||
    					obmocje[i+1][j]==prva ||
    					obmocje[i][j-1]==prva ||
    					obmocje[i][j+1]==prva ) {

    					return true;

    				}
    			}*/


    		}
    	}
    	return false;

    }

}
