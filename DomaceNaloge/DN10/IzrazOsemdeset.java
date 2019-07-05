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
		if(iz.niz.length() == 1) {
			iz = new Stevilo(iz.niz);
		} else {
			//levi je sestavljen, razbij ga
			//cist najprej mors upostevat oklepaje	-> se pravi prvi pa zadn oklepaj/zaklepaj skup paseta		
			//find lastIndexOf plus/minus  If not found than lastIndexOf multiplication/devision
			int ixOklepaj = iz.niz.indexOf('(');			
			if(ixOklepaj != -1) {
				if(ixOklepaj > 1) {
					//ce je nekaj pred oklepajem potem splitaj in zbrisi oklepaje		
					//System.out.println(	iz.niz.substring(0,ixOklepaj-1) + "  allora  " + iz.niz.charAt(ixOklepaj-1) + " e poi " + iz.niz.substring(ixOklepaj+1, iz.niz.length()-1));
					iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ixOklepaj-1)),
												 iz.niz.charAt(ixOklepaj-1), 
													new Izraz(iz.niz.substring(ixOklepaj+1, iz.niz.length()-1)));
				} else {
					int ixZaklepaj = iz.niz.lastIndexOf(')');
					System.out.println(iz.niz.substring(1,ixZaklepaj) + "  allora  " + iz.niz.charAt(ixZaklepaj+1) + " e poi " + iz.niz.substring(ixZaklepaj+2));
					iz = new SestavljenIzraz(new Izraz(iz.niz.substring(1,ixZaklepaj)),
												iz.niz.charAt(ixZaklepaj+1), 
												new Izraz(iz.niz.substring(ixZaklepaj+2)));
				}
			} else if (iz.niz.lastIndexOf('+') > iz.niz.lastIndexOf('-')) {	
				//plus
				int ix = iz.niz.lastIndexOf('+');
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ix)), 
											iz.niz.charAt(ix), 
											new Izraz(iz.niz.substring(ix+1)));

			} else if (iz.niz.lastIndexOf('+') < iz.niz.lastIndexOf('-')) {
				//minus
				int ix = iz.niz.lastIndexOf('-');
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ix)), 
											iz.niz.charAt(ix), 
											new Izraz(iz.niz.substring(ix+1)));

			} else if (iz.niz.lastIndexOf('*') > iz.niz.lastIndexOf('/')) {
				//multiplication
				int ix = iz.niz.lastIndexOf('*');
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ix)), 
											iz.niz.charAt(ix), 
											new Izraz(iz.niz.substring(ix+1)));

			}else if (iz.niz.lastIndexOf('*') < iz.niz.lastIndexOf('/')) {
				//devision
				int ix = iz.niz.lastIndexOf('/');
				iz = new SestavljenIzraz(new Izraz(iz.niz.substring(0,ix)), 
											iz.niz.charAt(ix), 
											new Izraz(iz.niz.substring(ix+1)));
			}

		}
		return iz;
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