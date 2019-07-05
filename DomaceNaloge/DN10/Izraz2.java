//63180224
public class Izraz {
	protected String niz;
	Izraz ukn;

	public Izraz(String niz) {
		this.niz = niz;
	}

	public static Izraz zgradi(String niz) {
		//izbrisi cisto okvirni oklepaj ce obstaja na ix 0 in niz.length()-1
		//ukn = new SestavljenIzraz(niz);

		if(niz.length()==1) {
			ukn = new Stevilo(niz);
		}
	
		return ukn;
	}

	public int steviloOperatorjev() {
		return ukn.stOperatorjev;
	}

	public String postfiksno() {
		return ukn.vrniPostfiks();
	}

	public int vrednost() {
		return ukn.vrniVrednost();
	}	

	public String vrniPostfiks() {return "";}
	public int vrniVrednost() {return -1;}

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
	public static int stOperatorjev = 0;

	public SestavljenIzraz(Izraz levi, char operator, Izraz desni) {
		this.levi = levi;
		this.desni = desni;
		this.operator = operator;		
		
		if(levi.niz.length() == 1) {
			levi = new Stevilo(levi.niz);
		} else {
			//levi je sestavljen, razbij ga
			//cist najprej mors upostevat oklepaje	-> se pravi prvi pa zadn oklepaj/zaklepaj skup paseta		
			//find lastIndexOf plus/minus  If not found than lastIndexOf multiplication/devision
			int ixOklepaj = levi.niz.indexOf('(');			
			if(ixOklepaj != -1) {
				if(ixOklepaj > 1) {
					//ce je nekaj pred oklepajem potem splitaj in zbrisi oklepaje					
					levi = new SestavljenIzraz(new Izraz(levi.niz.substring(0,ixOklepaj-1)),
												 new Izraz(levi.niz.charAt(ixOklepaj-1)), 
													new Izraz(levi.niz.substring(ixOklepaj+1, levi.niz.length()-1)));
				} else {
					int ixZaklepaj = levi.niz.lastIndexOf(')');
					levi = new SestavljenIzraz(new Izraz(levi.niz.substring(1,ixZaklepaj)),
												new Izraz(levi.niz.charAt(ixZaklepaj+1)), 
												new Izraz(levi.niz.substring(ixZaklepaj+2)));
				}
			} else if (levi.niz.lastIndexOf('+') > levi.niz.lastIndexOf('-')) {	
				//plus
				int ix = levi.niz.lastIndexOf('+');
				levi = new SestavljenIzraz(new Izraz(levi.niz.substring(0,ix)), 
											new Izraz(levi.niz.charAt(ix)), 
											new Izraz(levi.niz.substring(ix+1)));

			} else if (levi.niz.lastIndexOf('+') < levi.niz.lastIndexOf('-')) {
				//minus
				int ix = levi.niz.lastIndexOf('-');
				levi = new SestavljenIzraz(new Izraz(levi.niz.substring(0,ix)), 
											new Izraz(levi.niz.charAt(ix)), 
											new Izraz(levi.niz.substring(ix+1)));

			} else if (levi.niz.lastIndexOf('*') > levi.niz.lastIndexOf('/')) {
				//multiplication
				int ix = levi.niz.lastIndexOf('*');
				levi = new SestavljenIzraz(new Izraz(levi.niz.substring(0,ix)), 
											new Izraz(levi.niz.charAt(ix)), 
											new Izraz(levi.niz.substring(ix+1)));

			}else if (levi.niz.lastIndexOf('*') < levi.niz.lastIndexOf('/')) {
				//devision
				int ix = levi.niz.lastIndexOf('/');
				levi = new SestavljenIzraz(new Izraz(levi.niz.substring(0,ix)), 
											new Izraz(levi.niz.charAt(ix)), 
											new Izraz(levi.niz.substring(ix+1)));
			}

		}


		if(desni.niz.length() == 1) {
			desni = new Stevilo(desni.niz);
		} else {
			//desni je sestavljen, razbij ga
		
		}

		stOperatorjev++;
	}

	public SestavljenIzraz(String niz) {
		//to bi lahk tud v uni metodi nardil
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