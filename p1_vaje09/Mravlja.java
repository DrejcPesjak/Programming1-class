import java.util.Scanner;

public class Mravlja {
	
	/**
	 * Vrne stevilo poti od zgornjega levega do spodnjega desnega
	 * konta za steno s podano visino in sirino.
	 */
	
	private static int stPoti(int visina, int sirina) {
		// 3,4
		if (visina <= 1 || sirina <= 1){
			return 1;
		}
		return stPoti(visina - 1, sirina) + stPoti(visina, sirina - 1);	
	}
	
	/**
	 * Razlicica metode stPoti, ki uporablja memoizacijo -- pomnenje
	 * ze izracunanih vrednosti.
	 * @param memo memo[visina][sirina]: 0 oziroma ze izracunano
	 * stevilo poti za steno velikosti <visina> x <sirina> ali s x v
	 */
	 
	private static long stPotiMemo(int visina, int sirina, long[][] memo) {
		// na steni 1 x nekaj ali nekaj x 1 imamo samo eno mozno pot
		if (visina <= 1 || sirina <= 1){
			return 1;
		}
		
		// ali smo vrednost za steno visina x sirina morda ze izracunali ??!
		if (memo[visina][sirina] > 0) {
			return memo[visina][sirina];
		}
		if (memo[sirina][visina] > 0) {
			return memo[sirina][visina];
		}
		
		// ce nismo, bo treba do kolena v blato in izracunati z rekurzijo
		memo[visina][sirina] = 	stPotiMemo(visina - 1, sirina, memo) + 
								stPotiMemo(visina, sirina - 1, memo);
		return memo[visina][sirina];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int visina = sc.nextInt();
		int sirina = sc.nextInt();
		
		// osnovna razlicija
		// System.out.println(stPoti(visina, sirina));
		
		// razlicica z memoizacijo (ne memo-R-izacijo)
		int m = Math.max(visina, sirina) + 1;
		long[][] memo = new long[m][m];
		System.out.println(stPotiMemo(visina, sirina, memo));
	}
}