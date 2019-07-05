//63180224

public class Izraz {
	protected String niz;
	public static int stOperatorjev = 0;
	//Izraz ukn;

	public Izraz() {}
	public Izraz(String niz) {
		this.niz = niz;
	}

	public static Izraz zgradi(String niz) {
		//izbrisi cisto okvirni oklepaj ce obstaja na ix 0 in niz.length()-1
		//ukn = new SestavljenIzraz(niz);
		return  Izraz.splitajIzraz(new Izraz(niz));
	}

	public int steviloOperatorjev() {
		return this.stOperatorjev;
	}

	public String postfiksno() {
		return this.vrniPostfiks();
	}

	public int vrednost() {
		return this.vrniVrednost();
	}	

	public String vrniPostfiks() {return "";}
	public int vrniVrednost() {return -1;}

	protected static Izraz splitajIzraz(Izraz iz) {
		/*if(iz.niz.startsWith("(") && iz.niz.endsWith(")")) {
			iz.niz = iz.niz.substring(1, iz.niz.length -1);
		}*/
		
		if(iz.niz.length() == 1) { // je stevilo
			iz = new Stevilo(iz.niz);
		} else if(iz.niz.length() == 2 && (iz.niz.indexOf('(')!=-1 || iz.niz.indexOf(')')!=-1)) {
			iz.niz = iz.niz.replace("(", "");
			iz.niz = iz.niz.replace(")", "");
			iz = new Stevilo(iz.niz);
		} else if(iz.niz.length() == 3 && iz.niz.indexOf('(')!=-1 && iz.niz.indexOf(')')!=-1) {
			iz.niz = iz.niz.replace("(", "");
			iz.niz = iz.niz.replace(")", "");
			iz = new Stevilo(iz.niz);
		} else {
			//zanka za plus in minus, zmaga ker je bol desno v stringu (max index)
			int ixPlus = -1; int ixMinus = -1;
			for(int i = iz.niz.length() -1; i>=0; i--) {
				char trenutniChar = iz.niz.charAt(i);

				int stOklepajev = countMatches(iz.niz.substring(0,i), '(');
				int stZaklepajev = countMatches(iz.niz.substring(0,i), ')');

				if(stOklepajev-stZaklepajev == 0) {
					if(trenutniChar == '+') {
						ixPlus = (i>ixPlus) ? i:ixPlus;
					} else if(trenutniChar == '-') {
						ixMinus = (i>ixMinus) ? i:ixMinus;
					}
				}
			}


			if(ixPlus > ixMinus ) {
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ixPlus)), 
												iz.niz.charAt(ixPlus), 
												new Izraz(iz.niz.substring(ixPlus+1)));
			} else if(ixMinus>ixPlus) {
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ixMinus)), 
												iz.niz.charAt(ixMinus), 
												new Izraz(iz.niz.substring(ixMinus+1)));

			} else { //krat,deljenje, ali vse znotraj dveh oklepajev
				
				int ixKrat = -1; int ixDeljeno = -1;
				for(int i = iz.niz.length() -1; i>=0; i--) {
					char trenutniChar = iz.niz.charAt(i);

					int stOklepajev = countMatches(iz.niz.substring(0,i), '(');
					int stZaklepajev = countMatches(iz.niz.substring(0,i), ')');

					if(stOklepajev-stZaklepajev == 0) {
						if(trenutniChar == '*') {
							ixKrat = (i>ixKrat) ? i:ixKrat;
						} else if(trenutniChar == '/') {
							ixDeljeno = (i>ixDeljeno) ? i:ixDeljeno;
						}
					}
				}

				if(ixKrat > ixDeljeno) {
					iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ixKrat)), 
												iz.niz.charAt(ixKrat), 
												new Izraz(iz.niz.substring(ixKrat+1)));

				} else if(ixKrat < ixDeljeno) { 
					iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ixDeljeno)), 
												iz.niz.charAt(ixDeljeno), 
												new Izraz(iz.niz.substring(ixDeljeno+1)));

				} else { // odstrani cisto zunanje oklepaje
					//System.out.println(iz.niz);				
					iz.niz = iz.niz.substring(1, iz.niz.length() -1);
					iz = Izraz.splitajIzraz(iz);
				}

			}
		}

		return iz;
	}

	
	private static int countMatches(String neki, char c) {
		int stevec = 0;

		for(char s : neki.toCharArray()) {
			if(s==c) {
				stevec++;
			}
		}

		return stevec;
	}


}

class Stevilo extends Izraz {
	private int stevilka;
	
	public Stevilo(String st) {
		stevilka = Integer.parseInt(st);
	}

	@Override
	public int vrniVrednost() {
		return stevilka;
	}
	
	@Override
	public String vrniPostfiks() {
		return String.valueOf(stevilka);
	}

}

class SestavljenIzraz extends Izraz {
	Izraz levi; Izraz desni; char operator;

	public SestavljenIzraz(Izraz levi, char operator, Izraz desni) {
		this.levi = Izraz.splitajIzraz(levi);
		this.desni = Izraz.splitajIzraz(desni);
		this.operator = operator;		

		stOperatorjev++;
	}

	
	@Override
	public int vrniVrednost() {
		if(operator == '+') {
			return levi.vrniVrednost() + desni.vrniVrednost();
		} else if(operator == '-') {
			return levi.vrniVrednost() - desni.vrniVrednost();
		} else if(operator == '/') {
			return levi.vrniVrednost() / desni.vrniVrednost();
		} else {
			return levi.vrniVrednost() * desni.vrniVrednost();
		}
	}

	
	@Override
	public String vrniPostfiks() {
		return levi.vrniPostfiks() + desni.vrniPostfiks() + operator;
	}

}